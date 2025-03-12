package com.whj.local_test.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSONObject;
import com.whj.local_test.dao.StudentDao;
import com.whj.local_test.domain.dto.DaCard;
import com.whj.local_test.domain.entity.StudentEntity;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Api(tags = "测试用例")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/devTool")
    @ApiOperation("测试部署")
    public String testDevTool() {

        return " <h1 style=\"color: black;\">Springboot</h1>";
    }

    @ApiOperation("测试post请求单个请求参数")
    @PostMapping("/testSingleton")
    public Result<String> testSingleton(@RequestParam("name") String name) {
        String s = name;

        return Result.success(s);
    }

    @GetMapping("/testSaveDate")
    public Result<Date> testSaveDate() {
        StudentEntity studentEntity = new StudentEntity(12, "伍六七", "男", 4, new Date());
        studentDao.insert(studentEntity);
        return Result.success(studentEntity.getTime());
    }

    @PostMapping("/upload")
    public Result<String> uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {

        List<DaCard> datas = EasyExcel.read(file.getInputStream(), DaCard.class, null)
                .sheet()
                .doReadSync();
        for (DaCard data : datas) {
            JSONObject forObject = restTemplate.getForObject(data.getText(), JSONObject.class);
            System.out.println(forObject);
        }

        return Result.success();
    }
}
