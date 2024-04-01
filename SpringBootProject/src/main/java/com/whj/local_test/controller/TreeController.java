package com.whj.common_structures.controller;


import com.whj.common_structures.domain.TreeNode;
import com.whj.common_structures.domain.entity.TreeEntity;
import com.whj.common_structures.util.TreeBuild;
import com.whj.test.common.Result;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author whj
 * @since 2024-01-15 17:58:06
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:7070")
public class TreeController {

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

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("4","3");
        System.out.println(map.getOrDefault("333", "不存在"));
        System.out.println(map.getOrDefault("1", "不存在"));
    }
}

