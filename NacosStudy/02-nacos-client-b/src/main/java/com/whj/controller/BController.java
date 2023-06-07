package com.whj.controller;

import com.whj.common.Result;
import com.whj.domian.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/27
 * @描述
 */
@RestController
public class BController {


    @GetMapping("/info")
    public String info(){
        return "年薪20万";
    }

    @GetMapping("/getUser")
    public Result<User> getUser(){

        User user = new User();

        user.setAge(20);
        user.setName("张三");
        user.setBirthday(LocalDate.now());
        return Result.success(user);
    }
    @GetMapping("/getUserOther")
    public Result<User> getUserOther(){
        User user = new User();

        user.setAge(20);
        user.setName("张三");
        user.setBirthday(LocalDate.now());
        return Result.success(user);

    }
}
