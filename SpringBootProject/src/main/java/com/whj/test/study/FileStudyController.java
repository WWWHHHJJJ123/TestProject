package com.whj.test.study;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/6
 * @描述  文件上传和下载
 */
@RestController
public class FileStudyController {

    // 找一个计算机的磁盘位置，比如 D:\\, 我这里使用的是本项目的路径
    private static final String BASE_DIR = "E:\\MyLearnProject\\";

    /**
     * 文件上传,传完之后在你的 BASE_DIR目录下
     * @param file
     */
    // 定义接口类型和二级路径，完整的接口url是：/file/upload
    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file) {
        // 获取文件的名称
        String fileName = file.getOriginalFilename();
        try {
            // 新建一个文件路径
            File uploadFile = new File(BASE_DIR + fileName);
            // 当父级目录不存在时，自动创建
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            // 存储文件到电脑磁盘
            file.transferTo(uploadFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 下载接口，url: /file/download?fileName=xxx

    @GetMapping("/download")
    public void download(@RequestParam String fileName, HttpServletResponse response) {
        //  新建文件流，从磁盘读取文件流
        try (FileInputStream fis = new FileInputStream(BASE_DIR + fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = response.getOutputStream()) {    //  OutputStream 是文件写出流，讲文件下载到浏览器客户端
            // 新建字节数组，长度是文件的大小，比如文件 6kb, bis.available() = 1024 * 6
            byte[] bytes = new byte[bis.available()];
            // 从文件流读取字节到字节数组中
            bis.read(bytes);
            // 重置 response
            response.reset();
            // 设置 response 的下载响应头
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 注意，这里要设置文件名的编码，否则中文的文件名下载后不显示
            // 写出字节数组到输出流
            os.write(bytes);
            // 刷新输出流
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
