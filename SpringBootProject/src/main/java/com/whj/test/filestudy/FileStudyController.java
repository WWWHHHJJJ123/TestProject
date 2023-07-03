package com.whj.test.filestudy;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/6
 * @描述 文件上传和下载
 */
@RestController
@RequestMapping("/file")
public class FileStudyController {

    // 找一个计算机的磁盘位置，比如 D:\\, 我这里使用的是本项目的路径
    private static final String BASE_DIR = "E:\\";

    /**
     * 文件上传,传完之后在你的 BASE_DIR目录下
     *
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

    /**
     * @Description:下载
     * @Param downloadPath 文件路径
     */
    @GetMapping("/download")
    public String downloadPathFile(@RequestParam("downloadPath") String downloadPath,HttpServletResponse response) {
        System.out.println("----------------");
        //设置文件路径
        File file = new File(downloadPath);
        //获取文件名称
        String fileName = file.getName();
        //判断文件是否存在
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                file.delete();
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

}
