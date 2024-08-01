package com.zmh.infrastructure.utils.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description: RedisUtil
 * @author: zhou ming hao
 * @date: 2024年07月27日 18:41
 */

@Component
public class RedisUtil {

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

    public ValueOperations opsForValue(){
        return redisTemplate.opsForValue();
    }
}