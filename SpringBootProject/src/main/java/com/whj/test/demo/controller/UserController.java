package com.whj.test.demo.controller;

import com.whj.test.common.AjaxResult;
import com.whj.test.demo.domain.dto.UserPageResultVO;
import com.whj.test.demo.domain.vo.UserPageParamDTO;
import com.whj.test.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */
@Api("测试代码")
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("分页获取user")
    @PostMapping("/userPageInfo")
    public AjaxResult<List<UserPageResultVO>> getUserPageInfo(@RequestBody UserPageParamDTO userPageParamVO){
        List<UserPageResultVO> userPageResultDTOS = userService.selectUserList(userPageParamVO);
        return AjaxResult.success("成功",userPageResultDTOS);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
