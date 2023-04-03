package com.example.normal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 *
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        FastJson2JsonRedisSerializer<Object> json2JsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(json2JsonRedisSerializer);
        //hash的value也采用jackson序列化方式
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(json2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
