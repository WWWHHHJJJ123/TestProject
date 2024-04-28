package com.whj.local_test.controller;

import com.alibaba.fastjson2.JSONObject;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试用例")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/devTool")
    @ApiOperation("测试部署")
    public String testDevTool(){

        return " <h1 style=\"color: black;\">Springboot</h1>";
    }

    @ApiOperation("测试post请求单个请求参数")
    @PostMapping("/testSingleton")
    public Result<String> testSingleton(@RequestParam("name") String name){
        String s = name;

        return Result.success(s);
    }
}
