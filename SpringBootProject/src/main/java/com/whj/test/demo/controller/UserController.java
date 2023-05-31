package com.whj.test.demo.controller;

import com.whj.test.common.AjaxResult;
import com.whj.test.demo.domain.vo.UserPageResultVO;
import com.whj.test.demo.domain.dto.UsrListParamDTO;
import com.whj.test.demo.domain.enity.UserEntity;
import com.whj.test.demo.domain.dto.UserPageParamDTO;
import com.whj.test.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${modules.path}")
    private String path;

    @ApiOperation("分页获取user")
    @PostMapping("/userPageInfo")
    public AjaxResult<List<UserPageResultVO>> getUserPageInfo(@RequestBody UserPageParamDTO userPageParamDTO){
        List<UserPageResultVO> userPageResultDTOS = userService.selectUserList(userPageParamDTO);
        return AjaxResult.success("成功",userPageResultDTOS);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("插入一条user")
    @PostMapping("/insertUser")
    public AjaxResult insertUser(@RequestBody UserEntity user){
        int i = userService.insertUser(user);
        if (i==1){
            return AjaxResult.success("成功插入一条用户");
        }
        return AjaxResult.error("操作失败");
    }

    @ApiOperation("根据输入的参数查询userList")
    @PostMapping("/getUserListContainParam")
    public AjaxResult getUserListContainParam(UsrListParamDTO usrListParamDTO){

        List<UserEntity> userListContainParam = userService.getUserListContainParam(usrListParamDTO);
        return AjaxResult.success(userListContainParam);
    }

    @ApiOperation("获取一个用户信息((get请求第一种path传参))")
    @GetMapping("/getOneUser/{id}")
    public AjaxResult<UserEntity> getOneUser(@PathVariable Long id){

        UserEntity userEntity = userService.getOne(id);
        return AjaxResult.success("获取成功",userEntity);
    }

    @ApiOperation("获取路径信息")
    @GetMapping("/getAddress")
    public AjaxResult<String> getAddress(){
        return AjaxResult.success(path);
    }

    @ApiOperation("获取一个用户信息((get请求第二种path传参))")
    @GetMapping("/getUserById")
    public AjaxResult<UserEntity> getUserById(@RequestParam Long id){
        UserEntity userEntity = userService.getOne(id);
        return AjaxResult.success(userEntity);
    }
}
