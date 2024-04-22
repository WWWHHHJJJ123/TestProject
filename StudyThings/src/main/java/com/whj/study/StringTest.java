package com.whj.study;

import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/6
 * @描述
 */
public class StringTest {

    public static void main(String[] args) {

        StringBuilder sb=new StringBuilder("Hello,Word");
        sb.insert(6,"你好,");
        System.out.println(String.valueOf(sb));
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.insert(2,"11");
    }
}
