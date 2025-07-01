package com.whj.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CiZhong
 * @date 2025-06-24
 */
@RestController
public class UserController {
    @GetMapping("/get")
    public String home() {
        return "登录成功！<br>用户名: " + "<br>邮箱: ";
    }
}