package com.whj.test.excel.controller;


import com.alibaba.excel.EasyExcel;
import com.whj.test.common.Result;
import com.whj.test.excel.domain.vo.ZHDataVO;
import com.whj.test.excel.service.IAmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author whj
 * @since 2023-11-30 16:18:22
 */
@RestController
@RequestMapping("/excel")
public class AmsCategoryController {


    @Autowired
    private IAmsCategoryService categoryService;

    @PostMapping("/importExcel")
    public Result importExcelToDataSource(@RequestBody MultipartFile file) throws IOException{
        categoryService.importExcel(file);

        return Result.success();
    }
}

