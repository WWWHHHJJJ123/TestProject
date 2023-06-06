package com.whj.study;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/6
 * @描述
 */
public class StringTest {

    public static void main(String[] args) {
        String str="dadassdvjjjfmmf.ccc";
        System.out.println(str.lastIndexOf("."));
        System.out.println(str.substring(15));
        String substring = str.substring(str.lastIndexOf("."));
        System.out.println(substring);
    }
}
