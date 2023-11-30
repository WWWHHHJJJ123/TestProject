package com.whj.test.demo.controller;

import com.whj.test.common.Result;
import com.whj.test.demo.domain.vo.UserPageResultVO;
import com.whj.test.demo.domain.dto.UsrListParamDTO;
import com.whj.test.demo.domain.enity.UserEntity;
import com.whj.test.demo.domain.dto.UserPageParamDTO;
import com.whj.test.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */
@Slf4j
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
    public Result<List<UserPageResultVO>> getUserPageInfo(@RequestBody UserPageParamDTO userPageParamDTO){
        List<UserPageResultVO> userPageResultDTOS = userService.selectUserList(userPageParamDTO);
        return Result.success("成功",userPageResultDTOS);
    }

    @RequestMapping("/hello")
    public String hello(){

        log.info("输出路径"+path);
        return "hello";
    }

    @ApiOperation("插入一条user")
    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody UserEntity user){
        int i = userService.insertUser(user);
        if (i==1){
            return Result.success("成功插入一条用户");
        }
        return Result.error("操作失败");
    }

    @ApiOperation("根据输入的参数查询userList")
    @PostMapping("/getUserListContainParam")
    public Result getUserListContainParam(UsrListParamDTO usrListParamDTO){

        List<UserEntity> userListContainParam = userService.getUserListContainParam(usrListParamDTO);
        return Result.success(userListContainParam);
    }

    @ApiOperation("获取一个用户信息((get请求第一种path传参))")
    @GetMapping("/getOneUser/{id}")
    public Result<UserEntity> getOneUser(@PathVariable Long id){

        UserEntity userEntity = userService.getOneById(id);
        return Result.success("获取成功",userEntity);
    }

    @ApiOperation("获取路径信息")
    @GetMapping("/getAddress")
    public Result<String> getAddress(){
        return Result.success(path);
    }

    @ApiOperation("获取一个用户信息((get请求第二种path传参))")
    @GetMapping("/getUserById")
    public Result<UserEntity> getUserById(@RequestParam Long id){
        UserEntity userEntity = userService.getOneById(id);
        return Result.success(userEntity);
    }

    @GetMapping("/getObjectMap")
    public Result<List<Map<String,UserEntity>>> getObjectMap(){


        List<Map<String,UserEntity>> mapList=new ArrayList<>();
        Map<String,UserEntity> map1=new HashMap<>();
        map1.put("zhangsan",new UserEntity(1L,"张三",20,"www.zhangsan.com"));
        map1.put("lisi",new UserEntity(2L,"李四",20,"www.lisi.com"));
        map1.put("wangwu",new UserEntity(3L,"王五",20,"www.wangwu.com"));
        map1.put("zhaoliu",new UserEntity(4L,"赵六",20,"www.zhaoliu.com"));
        mapList.add(map1);
        Map<String,UserEntity> map2=new HashMap<>();
        map2.put("zhangsan",new UserEntity(1L,"张三",20,"www.zhangsan.com"));
        map2.put("lisi",new UserEntity(2L,"李四",20,"www.lisi.com"));
        map2.put("wangwu",new UserEntity(3L,"王五",20,"www.wangwu.com"));
        map2.put("zhaoliu",new UserEntity(4L,"赵六",20,"www.zhaoliu.com"));
        mapList.add(map2);

        return Result.success(mapList);
    }
}
