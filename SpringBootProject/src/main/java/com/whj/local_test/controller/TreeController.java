package com.whj.local_test.controller;


import com.whj.local_test.domain.TreeNode;
import com.whj.local_test.domain.dto.TreePageDTO;
import com.whj.local_test.domain.entity.TreeEntity;
import com.whj.local_test.service.ITreeService;
import com.whj.local_test.util.TreeBuild;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author whj
 * @since 2024-01-15 17:58:06
 */
@Api(tags = "tree的Controller")
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:7070")
public class TreeController {


    @Autowired
    private ITreeService treeService;

    /**
     * 案例构造一棵树，其余的可共用
     *
     * @return
     */
    @GetMapping("/data")
    public Result treeTest() {

        // 模拟测试数据（通常为数据库的查询结果）
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(new TreeNode(1, 0, "顶级节点A"));
        treeNodeList.add(new TreeNode(2, 0, "顶级节点B"));
        treeNodeList.add(new TreeNode(3, 1, "父节点是A"));
        treeNodeList.add(new TreeNode(4, 2, "父节点是B"));
        treeNodeList.add(new TreeNode(5, 2, "父节点是B"));
        treeNodeList.add(new TreeNode(6, 3, "父节点的ID是3"));

        // 创建树形结构（数据集合作为参数）
        TreeBuild treeBuild = new TreeBuild(treeNodeList);
        // 原查询结果转换树形结构
        treeNodeList = treeBuild.buildTree();
        // AjaxResult：个人封装返回的结果体
        return Result.success("测试数据", treeNodeList);
    }

    @PostMapping("/a3")
    public Result a3(@RequestHeader("Authorization") String authorization) {
        return Result.success(authorization);
    }

    @PostMapping("/a4")
    public Result a4(String name, Integer age) {
        System.out.println(name + age);
        return Result.success();
    }

    @PostMapping("/a5")
    public Result a4(@RequestBody TreeEntity treeEntity) {
        System.out.println(treeEntity.toString());
        return Result.success(treeEntity);
    }


    @ApiOperation("列表数据")
    @PostMapping("/list")
    public Result<List<TreeEntity>> list(@RequestBody TreePageDTO dto) {
        List<TreeEntity> list = treeService.list(dto);
        return Result.success(list);
    }

    @ApiOperation("导出数据")
    @PostMapping("/export")
    public void export(@RequestBody TreePageDTO dto,HttpServletResponse response) {
       treeService.export(dto,response);

    }


}

