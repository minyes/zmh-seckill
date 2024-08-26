package com.zmh.app.aspect.restrictor.aop;

import com.google.common.collect.ImmutableList;
import com.zmh.app.aspect.restrictor.annotation.RateLimiter;
import com.zmh.app.aspect.restrictor.common.LimitType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Description: LimitInterceptor
 * @author: zhou ming hao
 * @date: 2024年08月27日 2:45
 */
@Aspect
@Configuration
@Slf4j
public class LimitInterceptor {
    private static final String UNKNOWN = "unknown";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /*private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public LimitInterceptor(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }*/

    /**
     * execution(public * *(..))
     * 匹配所有目标类的public方法，但不匹配SmartSeller和protected void showGoods()方法。第一个*代表返回类型，第二个*代表方法名，而..代表任意入参的方法
     */

    @Around("execution(public * *(..)) && @annotation(com.zmh.app.aspect.restrictor.annotation.RateLimiter)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        RateLimiter limitAnnotation = method.getAnnotation(RateLimiter.class);

        LimitType limitType = limitAnnotation.limitType();
        String name = limitAnnotation.name();

        String key;
        int limitPeriod = limitAnnotation.period();
        int limitCount = limitAnnotation.count();

        /**
         * 根据限流类型获取不同的 key，如果不传，以方法名作为 key
         */
        switch (limitType) {
            case IP:
                key = getIpAddress();
                break;
            case CUSTOMER:
                key = limitAnnotation.key();
                break;
            default:
                key = StringUtils.upperCase(method.getName());
        }

        ImmutableList<String> keys = ImmutableList.of(StringUtils.join(limitAnnotation.prefix(), key));

        try {
            String luaScript = buildLuaScript();
            RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
            Number count = redisTemplate.execute(redisScript, keys, limitCount, limitPeriod);

            log.info("Access try count is {} for name = {} and key = {}", count, name, key);

            if (null != count && count.intValue() <= limitCount)
                // 环绕通知
                return pjp.proceed();
            else
                throw new RuntimeException("Current maximum number of visitors, please try again later!");
        } catch (Throwable e) {
            log.error("异常信息：{}", e.getLocalizedMessage());
            if (e instanceof RuntimeException)
                throw new RuntimeException(e.getLocalizedMessage());
            throw new RuntimeException("server exception");
        }
    }

    /**
     * 编写 redis Lua 限流脚本
     */
    public String buildLuaScript() {
        StringBuffer lua = new StringBuffer();
        lua.append("local c");
        lua.append("\nc = redis.call('get',KEYS[1])");
        // 调用不超过最大值，则直接返回
        lua.append("\nif c and tonumber(c) > tonumber(ARGV[1]) then");
        lua.append("\nreturn c;");
        lua.append("\nend");
        // 执行计算器自加
        lua.append("\nc = redis.call('incr',KEYS[1])");
        lua.append("\nif tonumber(c) == 1 then");
        // 从第一次调用开始限流，设置对应键值的过期
        lua.append("\nredis.call('expire',KEYS[1],ARGV[2])");
        lua.append("\nend");
        lua.append("\nreturn c;");
        return lua.toString();
    }


    /**
     * 获取 ip 地址
     */
    public String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
