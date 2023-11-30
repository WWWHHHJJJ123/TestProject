package com.whj.learn;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/8/31 15:34
 * @Version 1.0
 */

public class Test8 {
    public static void main(String[] args) {
//        List<String> name = new ArrayList<>();
//        name.add("张三");
//        name.add("李四");
//        name.add("王五");
//        name.add("赵六");
//        String names = "";
//        names = String.join("/", name);
//        System.out.println(names);
//        String delete = StringUtils.delete("1234567", "345");
//        System.out.println(delete);
        String name="abcd";
        String substring = name.substring(name.length() - 2);
        System.out.println(substring);
        char[] charArray = name.toCharArray();
        for (int i = 0; i <charArray.length ; i++) {
            System.out.println(charArray[i]);
        }
    }
}
