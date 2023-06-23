package com.whj.test.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/18
 * @描述
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(factory);

        GenericJackson2JsonRedisSerializer serializer=new GenericJackson2JsonRedisSerializer();

        //key序列化方式
        template.setKeySerializer(serializer);
        //value序列化
        template.setValueSerializer(serializer);
        //value hashmap序列化
        template.setHashValueSerializer(serializer);
        //key haspmap序列化
        template.setHashKeySerializer(serializer);

        return template;
    }


}
