package com.zmh.app.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Description: RedisConfig
 * @author: zhou ming hao
 * @date: 2024年07月27日 18:40
 */


@EnableCaching  // 开启缓存
@Configuration  // 配置类
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${redis.hostname}")
    private String REDIS_HOSTNAME;

    @Value("${redis.port}")
    private int REDIS_PORT;

    @Value("${redis.maxTotal}")
    private int REDIS_MAX_TOTAL;

    @Value("${redis.maxIdle}")
    private int REDIS_MAX_IDLE;

    @Value("${redis.minIdle}")
    private int REDIS_MIN_IDLE;

    @Value("${redis.maxWaitMills}")
    private int REDIS_MAX_WAIT_MILLIS;

    /**
     * 配置 Redis 连接工厂
     * 意义: LettuceConnectionFactory 是连接 Redis 服务器的入口，它使用了 Lettuce 客户端，并且配置了连接池来提高性能和资源管理
     * @return LettuceConnectionFactory
     */
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        // 配置 Redis 服务器的连接信息
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(REDIS_HOSTNAME);
        redisStandaloneConfiguration.setPort(REDIS_PORT);
        // redisStandaloneConfiguration.setPassword("password"); // 取消注释以设置密码

        // 配置连接池
        GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(REDIS_MAX_TOTAL);       // 连接池中的最大连接数
        poolConfig.setMaxIdle(REDIS_MAX_IDLE);         // 连接池中的最大空闲连接数
        poolConfig.setMinIdle(REDIS_MIN_IDLE);         // 连接池中的最小空闲连接数
        poolConfig.setMaxWaitMillis(REDIS_MAX_WAIT_MILLIS); // 连接池获取连接的最大等待时间

        // 创建一个带有连接池配置的 Lettuce 客户端配置
        LettucePoolingClientConfiguration lettucePoolingClientConfiguration =
                LettucePoolingClientConfiguration.builder()
                        .poolConfig(poolConfig)
                        .build();

        // 返回带有连接池配置的 Redis 连接工厂
        return new LettuceConnectionFactory(redisStandaloneConfiguration, lettucePoolingClientConfiguration);
    }

    /**
     * 配置并返回一个 RedisTemplate 实例，用于执行 Redis 操作
     * 意义: RedisTemplate 提供了一种高级抽象，使得开发者可以通过模板方法操作 Redis，而无需直接处理底层的 Redis 命令。
     * 它支持多种 Redis 操作，例如值操作、哈希操作、列表操作等
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        /*
            1.创建 RedisTemplate: 这是 Spring 用于与 Redis 交互的核心类，简化了与 Redis 的交互。
            2.设置连接工厂: 使用前面定义的 LettuceConnectionFactory。
            3.设置序列化器: 设置键和值的序列化器，这里使用 StringRedisSerializer 来将键和值序列化为字符串。
         */
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());  // 设置连接工厂
        template.setKeySerializer(new StringRedisSerializer());  // 设置键的序列化器
        template.setValueSerializer(new StringRedisSerializer()); // 设置值的序列化器
        return template;
    }
}

