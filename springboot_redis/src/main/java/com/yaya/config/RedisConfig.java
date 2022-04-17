package com.yaya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object>template=new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return template;
//
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setKeySerializer(serializer);
//        return template;
    }
}