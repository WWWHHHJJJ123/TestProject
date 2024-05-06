package com.whj.local_test.controller;

import com.alibaba.fastjson2.JSONObject;
import com.whj.local_test.dao.StudentDao;
import com.whj.local_test.domain.entity.StudentEntity;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = "测试用例")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentDao studentDao;

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

    @GetMapping("/testSaveDate")
    public Result<Date> testSaveDate(){
        StudentEntity studentEntity=new StudentEntity(12,"伍六七","男",4,new Date());
        studentDao.insert(studentEntity);
        return Result.success(studentEntity.getTime());
    }
}
