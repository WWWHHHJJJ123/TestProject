package com.whj.controller;

import com.whj.common.Result;
import com.whj.domain.entity.User;
import com.whj.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/27
 * @描述
 */
@RestController
public class AController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/test")
    public String test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        System.out.println(instances);
        String info = testFeign.info();
        return info;
    }
    @GetMapping("/getUser")
    public Result getUser(){

        Result user = testFeign.getUser();
        return Result.success(user);
    }

    @GetMapping("/getUserOther")
    public Result<User> getUserOther(){

        Result<User> userOther = testFeign.getUserOther();
        User user = userOther.getData();
        return Result.success(user);
    }
}
