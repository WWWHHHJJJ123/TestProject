package com.whj.learn;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @创建人 JieSi
 * @创建时间 2023/5/16
 * @描述
 */
public class Test {
    public static void main(String[] args) {
//        String string=" fff    ";
//        System.out.println("string去空之前的长度:"+string.length());
//        System.out.println("==============");
//        String s = StringUtils.trimWhitespace(string);
//        System.out.println("string去空之后的长度:"+s.length());
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
//        System.out.println("通过Map.entrySet遍历key和value");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//        }
        Set<String> strings = map.keySet();
        for (String s:strings){
            String s1 = map.get(s);
            System.out.println("key:"+s+","+"value:"+s1);
        }
    }
}
