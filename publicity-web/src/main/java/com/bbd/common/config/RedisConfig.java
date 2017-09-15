/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common.config;

import com.google.common.collect.Maps;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * Redis,可以试试CachingConfigurerSupport。
 *
 * @author tjwang
 * @version $Id: RedisConfig.java, v 0.1 2017/7/7 0007 11:33 tjwang Exp $
 */
//@Configuration
//@EnableCaching(proxyTargetClass = true)
public class RedisConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMinIdle(10);
        config.setMaxIdle(20);
        config.setMaxTotal(1024);
        config.setMaxWaitMillis(100000);
        config.setTestOnBorrow(true);

        return config;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisConnectionFactory factory = new JedisConnectionFactory();

        factory.setPoolConfig(poolConfig);
        factory.setHostName("10.28.200.241");
        factory.setPort(6379);
        factory.setUsePool(true);
        factory.setDatabase(1);

        return factory;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();

        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return redisTemplate;
    }

    @Bean
    public CacheManager redisCacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        cacheManager.setDefaultExpiration(10 * 60);

        Map<String, Long> expires = Maps.newHashMap();
        cacheManager.setExpires(expires);

        return cacheManager;
    }

}
