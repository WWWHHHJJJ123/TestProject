package com.whj;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whj.test.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

class SpringBootProjectApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60);
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("userId", 123)//payload
                .withClaim("userName", "zhangSan")
                .withExpiresAt(instance.getTime())//指定令牌的过期时间
                .sign(Algorithm.HMAC256("!Q@W#E$R"));//签名
        System.out.println(token);
    }

    @Test
    public void test() {
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!Q@W#E$R")).build();

        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6InpoYW5nU2FuIiwiZXhwIjoxNjgzOTY2Mjk0LCJ1c2VySWQiOjEyM30.XsIV3u7-FABuC8MVjDFp4A80DQv2Yao88jfUtvmzz9Y");

        System.out.println(verify.getClaim("userId"));
        System.out.println(verify.getClaim("userName"));
    }

    @Test
    void tsetGetByPage() {
        IPage page = new Page(1, 2);
        userMapper.selectPage(page, null);
        System.out.println("当前页码值" + page.getCurrent());
        System.out.println("每页显示数" + page.getSize());
        System.out.println("一共多少页" + page.getPages());
        System.out.println("一共多少条" + page.getTotal());
        System.out.println("数据:" + page.getRecords());
    }
}
