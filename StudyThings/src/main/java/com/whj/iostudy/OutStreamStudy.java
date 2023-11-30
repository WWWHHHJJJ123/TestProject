package com.whj.iostudy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JieSir
 * @Date 2023/8/12 14:05
 * @Version 1.0
 */

public class OutStreamStudy {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=null;
        try {
           fos = new FileOutputStream("E:\\TestProject\\a.txt");
            fos.write(97);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            fos.close();
        }


    }
}
