package com.whj.redis.interfaceIdempotency.controller;

import com.whj.redis.interfaceIdempotency.Idempotent;
import com.whj.redis.interfaceIdempotency.model.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CiZhong
 * @date 2025-03-24
 */
@RestController
public class OrderController {

    @PostMapping("/orders")
    @Idempotent(expireTime = 60)
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        // 模拟订单创建逻辑
        return "Order created successfully";
    }


    public static void main(String[] args) {
        System.out.println(hasChinese("香芹/Emily Wang"));
        System.out.println(hasChinese("/Emily Wang"));
        System.out.println(hasChinese("Emily Wang"));
        System.out.println(hasChinese("Emily Wang@$"));
    }


    public static boolean hasChinese(String nickNameText) {
        // 正则表达式匹配中文字符
        String regex = "[\u4e00-\u9fa5/@#$%^&*:;]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nickNameText);
        return matcher.find();
    }
}