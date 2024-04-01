package com.whj.local_test.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whj.local_test.dao.StudentDao;
import com.whj.local_test.domain.dto.StudentsPageDTO;
import com.whj.local_test.domain.vo.StudentsPageVO;
import com.whj.local_test.domain.entity.StudentEntity;
import com.whj.test.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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
        IPage<StudentEntity> studentEntityIPage = studentDao.selectPage(iPage, Wrappers.<StudentEntity>lambdaQuery()
                .like(Objects.nonNull(dto.getName())&& StringUtils.isNotBlank(dto.getName()),StudentEntity::getName,dto.getName())
                .in(Objects.nonNull(dto.getAge()),StudentEntity::getAge,dto.getAge())
                .eq(Objects.nonNull(dto.getSex())&&StringUtils.isNotBlank(dto.getSex()),StudentEntity::getSex,dto.getSex()));
        vo.setStudentsList(studentEntityIPage.getRecords());
        vo.setTotal(studentEntityIPage.getTotal());
        return Result.success(vo);
    }

}

