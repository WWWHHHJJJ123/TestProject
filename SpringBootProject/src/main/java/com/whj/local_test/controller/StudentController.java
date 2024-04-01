package com.whj.common_structures.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whj.common_structures.dao.StudentDao;
import com.whj.common_structures.domain.dto.StudentsPageDTO;
import com.whj.common_structures.domain.vo.StudentsPageVO;
import com.whj.common_structures.domain.entity.StudentEntity;
import com.whj.test.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author whj
 * @since 2024-03-07 17:36:26
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/students")
    public Result<List<StudentEntity>> students() {
        List<StudentEntity> studentEntities = studentDao.selectList(Wrappers.<StudentEntity>lambdaQuery());
        return Result.success(studentEntities);
    }

    @GetMapping("/page/students")
    public Result<StudentsPageVO> pageStudents(StudentsPageDTO dto) {
        StudentsPageVO vo = new StudentsPageVO();
        IPage<StudentEntity> iPage=new Page<>(dto.getPageNum(),dto.getPageSize());
        IPage<StudentEntity> studentEntityIPage = studentDao.selectPage(iPage, null);
        vo.setStudentsList(studentEntityIPage.getRecords());
        vo.setTotal(studentEntityIPage.getTotal());
        return Result.success(vo);
    }

}

