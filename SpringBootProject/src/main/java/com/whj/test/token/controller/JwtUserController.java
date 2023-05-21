package com.whj.test.token.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.whj.test.token.domain.entity.JwtUser;
import com.whj.test.token.service.JwtUserService;
import com.whj.test.token.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/21
 * @描述
 */
@RestController
@Slf4j
public class JwtUserController {

    @Autowired
    private JwtUserService jwtUserService;

    @GetMapping("/jwtUser/login")
    public Map<String, Object> login(JwtUser jwtUser) {
        log.info("用户名:[[]]" + jwtUser.getName());
        log.info("密码:[[]]" + jwtUser.getPassword());
        Map<String, Object> map = new HashMap<>();

        try {
            JwtUser user = jwtUserService.login(jwtUser);
            Map<String, String> payload = new HashMap<>();
            payload.put("userId", user.getId().toString());
            payload.put("userName", user.getName());
            //生成jwt的令牌
            String token = JWTUtils.getToken(payload);
            map.put("state", "true");
            map.put("msg", "认证成功");
            map.put("token", token);//响应token
        } catch (Exception e) {
            map.put("state", "false");
            map.put("msg", e.getMessage());
        }

        return map;
    }


    @PostMapping("/jwtUser/test")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("msg", "请求成功");
        return map;
    }
}
