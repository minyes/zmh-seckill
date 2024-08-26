package com.zmh.app.aspect.restrictor.annotation;


import com.zmh.app.aspect.restrictor.common.LimitType;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RateLimiter {

    /**
     * 名字
     */
    String name() default "";

    /**
     * key
     */
    String key() default "";

    /**
     * key 的前缀
     */
    String prefix() default "";

    /**
     * 给定的时间范围 单位（秒）
     */
    int period();

    /**
     * 一定时间内最多访问次数
     */
    int count();

    /**
     * 限流类型（用户自定义 key 或者 请求 ip）
     */
    LimitType limitType() default LimitType.CUSTOMER;


}
