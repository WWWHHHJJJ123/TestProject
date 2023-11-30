package com.whj.controller;

import com.alibaba.excel.EasyExcel;
import com.whj.domain.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/7/30 15:03
 * @Version 1.0
 */

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    public String getIndex() {

        return "Hello Word";
    }

    @PostMapping("/upload")
    public List<UserEntity> upload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        return EasyExcel.read(inputStream).head(UserEntity.class).headRowNumber(7).sheet(0).doReadSync();
    }
}
