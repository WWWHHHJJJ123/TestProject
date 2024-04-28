package com.whj.stringStudy;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson2.JSONObject;
import com.whj.stream.domain.User;
import org.junit.jupiter.api.Test;

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

    @Test
    public void stringTest1(){

        String s="1,2,3,4";
        String[] split = s.split(",");

        for (String string : split) {
            System.out.println(string);
        }
    }

    @Test
    public void testJson(){
        User user1 = new User(1, "张三", 10);
        User user2 = new User(1, "张三", 10);
        String s1= JSONObject.toJSONString(user1);
        String S2= JSONObject.toJSONString(user2);
        System.out.print("对象的==判断:  ");
        System.out.println(user1==user2);
        System.out.print("对象的equals判断:  ");
        System.out.println(user1.equals(user2));
        System.out.println("======================");
        System.out.print("JSON字符串的==判断: ");
        System.out.println(s1==S2);
        System.out.print("JSON字符串的equals判断: ");
        System.out.println(s1.equals(S2));
    }
}
