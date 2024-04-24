package com.whj.study;

import cn.hutool.core.util.RandomUtil;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/6
 * @描述
 */
public class StringTest {

    public static void main(String[] args) {
        int a=4,b=5;
        System.out.println((int) (a+b)/2);
        System.out.println((double) (a+b)/2);
        System.out.println((float) (a+b)/2);
    }

    private static String createCode() {
        long now = System.currentTimeMillis();
        String nowStr = (now + "").substring(0, 10);
        String code = RandomUtil.randomString(3) + nowStr;
        return code;
    }
}
