package com.whj.local_test.controller;


import com.whj.local_test.dao.PersonMapper;
import com.whj.local_test.domain.entity.PersonDO;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author whj
 * @since 2024-10-11 16:59:59
 */
@Api(tags = "测试本地数据库")
@RestController
@RequestMapping("/personDO")
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @ApiOperation("测试")
    @GetMapping("/getPersons")
    public Result<List<PersonDO>> getPersons() {

        return Result.success(personMapper.selectAll());
    }
}

