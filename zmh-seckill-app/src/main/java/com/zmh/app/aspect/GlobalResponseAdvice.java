package com.zmh.app.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.zmh.app.result.IgnoreRestControllerResponseAdvice;
import com.zmh.app.result.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description: GlobalResponseAdvice
 * @author: zhou ming hao
 * @date: 2024年07月28日 17:06
 */

@RestControllerAdvice(basePackages = {"com.zmh.trigger"})
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 方法没有IgnoreRestControllerResponseAdvice注解，且response不是ResponseResult类型时启用beforeBodyWrite
        return !returnType.hasMethodAnnotation(IgnoreRestControllerResponseAdvice.class)
                && !returnType.getParameterType().isAssignableFrom(Result.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果返回值是void类型，直接返回200状态信息
        if (returnType.getParameterType().isAssignableFrom(void.class)) {
            return Result.success();
        }
        if (!(body instanceof Result)) {
            // warning: RestController方法上返回值类型为String时，响应的Content-Type是text/plain，需要手动指定为application/json
            if (body instanceof String) {
                    return JSONUtils.toJSONString(Result.success(body));
            }
            return Result.success(body);
        }
        return body;
    }
}
