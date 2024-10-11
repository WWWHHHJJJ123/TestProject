package com.example.company.test.confluence.controller;


import com.alibaba.fastjson2.JSONObject;
import com.example.company.test.confluence.common.Result;
import com.example.company.test.confluence.domain.ao.SpacePermissionAO;
import com.example.company.test.confluence.service.ISpacesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author whj
 * @since 2024-08-29 19:11:38
 */
@RestController
@RequestMapping("/space/permissions")
public class SpacePermissionsController {


    @Autowired
    private ISpacesService iSpacesService;

    @Autowired
    private RestTemplate restTemplate;

    private final String url="http://10.10.52.125:8090/rest/plugin-demo/1.0/demo/%s/%s";

    @ApiOperation("将指定人的空间权限赋予他人")
    @PostMapping("/toTarget")
    public Result<String> toTarget(
            @RequestBody SpacePermissionAO ao
    ) {

        iSpacesService.toTarget(ao);
        return null;
    }

    @ApiOperation("将指定人的空间权限赋予他人")
    @GetMapping("/test1")
    public Result<String> test1(
          @RequestParam("target") String target,
          @RequestParam("value") String value
    ) {

        JSONObject forObject = restTemplate.getForObject(String.format(url, target, value), JSONObject.class);

        return Result.success(forObject.toString());
    }

    @ApiOperation("删除关于离职人员的有限空间权限")
    @GetMapping("/deleteLimit")
    public Result<Boolean> deleteLimit(
            @RequestParam("ldap") String ldap
    ){
        Boolean limit = iSpacesService.deleteLimit(ldap);
        return Result.success(limit);
    }

}

