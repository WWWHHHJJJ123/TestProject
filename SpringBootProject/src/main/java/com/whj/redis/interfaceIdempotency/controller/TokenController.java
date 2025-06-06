package com.whj.redis.interfaceIdempotency.controller;

import com.whj.redis.interfaceIdempotency.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author CiZhong
 * @date 2025-03-24
 */
@RestController
public class TokenController {

    private final RedisUtil redisUtil;

    public TokenController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @GetMapping("/api/token")
    public String getToken() {
        String token = generateToken();
        // 将 token 存储到 Redis 中，设置一个较长的过期时间（例如 30 分钟）
        redisUtil.setIfAbsent("token:" + token, "1", 1800);
        return token;
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}