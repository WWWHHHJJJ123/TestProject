package com.whj.local_test.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSONObject;
import com.whj.local_test.dao.StudentDao;
import com.whj.local_test.domain.dto.DaCard;
import com.whj.local_test.domain.entity.StudentEntity;
import com.whj.test.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "测试用例")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/devTool")
    @ApiOperation("测试部署")
    public String testDevTool() {

        return " <h1 style=\"color: black;\">Springboot</h1>";
    }

    @ApiOperation("测试post请求单个请求参数")
    @PostMapping("/testSingleton")
    public Result<String> testSingleton(@RequestParam("name") String name) {
        String s = name;

        return Result.success(s);
    }

    @GetMapping("/testSaveDate")
    public Result<Date> testSaveDate() {
        StudentEntity studentEntity = new StudentEntity(12, "伍六七", "男", 4, new Date());
        studentDao.insert(studentEntity);
        return Result.success(studentEntity.getTime());
    }

    @PostMapping("/upload")
    public Result<String> uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {

        List<DaCard> datas = EasyExcel.read(file.getInputStream(), DaCard.class, null)
                .sheet()
                .doReadSync();
        for (DaCard data : datas) {
            JSONObject forObject = restTemplate.getForObject(data.getText(), JSONObject.class);
            System.out.println(forObject);
        }

        return Result.success();
    }

    @PostMapping("/meeting/room/upload")
    public Result<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        // 上传目标URL
        String url = "https://coreland-alpha.qunhequnhe.com/coreland/api/v2/attachments/upload";

        try {
            // 创建表单部分
            MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();

            // 添加文本字段
            formData.add("businessType", "coreland");

            // 添加文件
            // 为文件创建资源，保留原始文件名
            ByteArrayResource fileResource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            };
            formData.add("file", fileResource);

            // 设置请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Cookie", "qunheinternalsso=aEK+pPuXWFRqhj7gWE2po5ogufyuuX/HxEbCTU6htq0=; _ga=GA1.2.680597343.1741767927; corelanddi=ea51b887-01ce-4d86-879a-1dce22a0af6b; qhdi=06eedc09ff2311efaa8dedbed3aee205; pubinternalsso=aEK+pPuXWFRDvaUtwNg0afT9mgmHHVLszm0QZnMNnCc=; _hjSessionUser_1524981=eyJpZCI6IjlmYTgxZjJiLTJjOWEtNTAzZC05ZTlkLTRmMDBhNDdjNWIyMiIsImNyZWF0ZWQiOjE3NDI5Nzk2MTU2OTIsImV4aXN0aW5nIjpmYWxzZX0=; SESSION=7389b10b-9549-4ef9-a944-84d6dba4ecd9; qh-locale=zh_CN; _gid=GA1.2.1456876559.1743990048; JSESSIONID=node0rs7keldoc74n1eefhs893z7a2420307.node0");

            // 创建请求实体
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(formData, headers);

            // 发送请求
            ResponseEntity<JSONObject> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    JSONObject.class
            );

            // 处理响应
            if (response.getStatusCode().is2xxSuccessful()) {
                JSONObject responseBody = response.getBody();
                // 假设响应包含url字段作为上传后的文件URL
                if (responseBody != null && responseBody.containsKey("url")) {
                    return Result.success(responseBody.getString("url"));
                } else {
                    return Result.success("文件上传成功");
                }
            } else {
                return Result.error("文件上传失败: " + response.getStatusCodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("文件上传异常: " + e.getMessage());
        }
    }
}
