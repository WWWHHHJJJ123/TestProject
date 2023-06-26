package com.whj.file;

import java.io.File;
import java.io.IOException;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/24
 * @描述
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File f1=new File("E:\\java.txt");
        boolean newFile = f1.createNewFile();
        System.out.println(newFile);

        System.out.println("======================");
        File f2=new File("E:\\file");
        boolean mkdir = f2.mkdir();
        System.out.println(mkdir);
        System.out.println("==================");
        File f3=new File("E:\\file\\JavaWeb\\servlet");
        System.out.println(f3.mkdirs());
        System.out.println("======================");

    }
}
