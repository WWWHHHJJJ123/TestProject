package com.whj.local_test.controller;

import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试用例")
@RestController
public class TestController {

    @GetMapping("/test/devTool")
    @ApiOperation("测试部署")
    public String testDevTool(){

        return " <h1 style=\"color: black;\">Springboot</h1>";
    }
}
