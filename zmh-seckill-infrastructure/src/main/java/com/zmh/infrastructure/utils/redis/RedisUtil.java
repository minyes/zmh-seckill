package com.zmh.infrastructure.utils.redis;

import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: RedisUtil
 * @author: zhou ming hao
 * @date: 2024年07月27日 18:41
 */

@Component
public class RedisUtil {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /*
        意义: RedisTemplate 是 Spring 提供的一个 Redis 操作模板，它抽象了 Redis 的底层访问，
        使开发者可以用 Java 对象操作 Redis。使用 @Autowired 注解，Spring 自动将配置好的 RedisTemplate 注入到 RedisService 类中
     */
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 作用: 向 Redis 中存储一个键值对
    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 作用: 从 Redis 中获取指定键的值
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 作用: 向 Redis 中存储一个键值对，并设置其过期时间
    // timeout 指定时间量，timeUnit 指定时间单位
    public void setValueWithExpiry(String key, Object value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    // 作用: 从 Redis 中删除指定键及其对应的值
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

    public ValueOperations opsForValue() {
        return redisTemplate.opsForValue();
    }


    /**
     * 分布式上锁
     * @param lockKey
     * @param expireTime
     * @param identifier  UUID 持锁凭证
     * @return
     */
    public Boolean tryLock(String lockKey, long expireTime,String identifier) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            byte[] key = lockKey.getBytes();
            byte[] value = identifier.getBytes();
            Expiration expiration = Expiration.from(expireTime, TimeUnit.SECONDS);
            // 如果没有设置上锁
            return connection.set(key, value,expiration, RedisStringCommands.SetOption.SET_IF_ABSENT);
        });
    }

    /**
     * 分布式解锁
     * @param lockKey
     * @param identifier UUID 持锁凭证
     * @return
     */
    public Boolean unlock(String lockKey, String identifier) {
        // 使用 Lua 脚本来避免由于客户端异常而导致锁无法释放的问题
        // 注意：这里的脚本需要根据实际情况进行优化，以下是一个简单示例
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setScriptText(
                "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                        "   return redis.call('del', KEYS[1]) " +
                        "else " +
                        "   return 0 " +
                        "end");
        script.setResultType(Long.class);

        Long result = redisTemplate.execute(script, Collections.singletonList(lockKey), identifier);
        if (result != null && result.equals(1L)) {
            // 释放锁成功
            return true;
        } else {
            // 释放锁失败，可能是因为锁已经过期或者被其他客户端持有
            return false;
        }
    }

    /**
     * 执行lua脚本
     * @param luaStr
     * @return
     */
    public String executeLua(String luaStr) {
        RedisScript<String> redisScript = new DefaultRedisScript<>(luaStr, String.class);
        List<String> keys = Arrays.asList("luaKey");
        return redisTemplate.execute(redisScript, keys);
    }
}