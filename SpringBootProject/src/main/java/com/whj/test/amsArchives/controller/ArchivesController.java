package com.whj.test.amsArchives.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.api.R;
import com.whj.test.amsArchives.dao.AmsArchivesNewDao;
import com.whj.test.amsArchives.dateListener.ArchivesListener;
import com.whj.test.amsArchives.domain.dto.ExcelImportDTO;
import com.whj.test.amsArchives.domain.entity.AmsArchivesNewEntity;
import com.whj.test.amsArchives.domain.entity.Student;
import com.whj.test.amsArchives.service.ArchivesService;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Api(tags = "档案管理")
@RequestMapping("/archives")
@RestController
public class ArchivesController {


    @Autowired
    private AmsArchivesNewDao newDao;

    @Autowired
    private ArchivesService service;

    @PostMapping("/import")
    public Result importExcelToDataSource(@RequestBody MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        List<ExcelImportDTO> dataList = EasyExcel
                .read(inputStream, ExcelImportDTO.class, new ArchivesListener())
                .sheet()
                .headRowNumber(1)
                .doReadSync();
        Long firstId = null;
        Long secondId = null;
        String archivesCode = null;
        String fieldCode = null;
        for (ExcelImportDTO dto : dataList) {
            if (Objects.nonNull(dto.getArchives())) {
                AmsArchivesNewEntity first = new AmsArchivesNewEntity();
                first.setName(dto.getArchives());
                first.setModeCode(dto.getArchivesCode());
                archivesCode = dto.getArchivesCode();
                first.setModeCode(archivesCode);
                first.setPid(0L);
                newDao.insert(first);
                firstId = first.getId();
                if (Objects.nonNull(dto.getFirstField())) {
                    AmsArchivesNewEntity second = new AmsArchivesNewEntity();
                    second.setName(dto.getFirstField());
                    fieldCode = dto.getFieldCode();
                    second.setModeCode(fieldCode);
                    second.setPid(firstId);
                    newDao.insert(second);
                    secondId = second.getId();
                    AmsArchivesNewEntity third = new AmsArchivesNewEntity();
                    third.setName(dto.getSecondField());
                    third.setPid(secondId);
                    newDao.insert(third);
                } else {
                    AmsArchivesNewEntity third = new AmsArchivesNewEntity();
                    third.setName(dto.getSecondField());
                    third.setPid(secondId);
                    newDao.insert(third);
                }
            } else {
                if (Objects.nonNull(dto.getFirstField())) {
                    AmsArchivesNewEntity second = new AmsArchivesNewEntity();
                    second.setName(dto.getFirstField());
                    fieldCode = dto.getFieldCode();
                    second.setModeCode(fieldCode);
                    second.setPid(firstId);
                    newDao.insert(second);
                    secondId = second.getId();
                    AmsArchivesNewEntity third = new AmsArchivesNewEntity();
                    third.setName(dto.getSecondField());
                    third.setPid(secondId);
                    newDao.insert(third);
                } else {
                    AmsArchivesNewEntity third = new AmsArchivesNewEntity();
                    third.setName(dto.getSecondField());
                    third.setPid(secondId);
                    newDao.insert(third);
                }
            }
        }
        return Result.success(dataList);
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(7);
        set.add(2);
        set.add(10);
        set.add(-1);
        set.add(6);
//        System.out.println(set);
        Set<Student> students = new HashSet<>();
        students.add(new Student("张三", 2));
        students.add(new Student("李四", 10));
        students.add(new Student("王五", 11));
        students.add(new Student("赵六", 30));
        System.out.println(students);
    }

}
