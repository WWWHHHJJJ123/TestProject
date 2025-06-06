package com.whj.redis.interfaceIdempotency.interceptor;

import com.whj.redis.interfaceIdempotency.Idempotent;
import com.whj.redis.interfaceIdempotency.util.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author CiZhong
 * @date 2025-03-24
 */
@Aspect
@Component
public class IdempotentInterceptor {

    private final RedisUtil redisUtil;

    public IdempotentInterceptor(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Around("@annotation(idempotent)")
    public Object around(ProceedingJoinPoint joinPoint, Idempotent idempotent) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Idempotent-Token");

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Idempotent token is missing");
        }

        String key = "idempotent:" + token;
        String value = UUID.randomUUID().toString();

        if (!redisUtil.setIfAbsent(key, value, idempotent.expireTime())) {
            throw new RuntimeException("Duplicate request");
        }

        try {
            return joinPoint.proceed();
        } finally {
            redisUtil.delete(key);
        }
    }
}