package com.whj.String;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author admin
 * @date 2024-10-16
 */
public class StringTest {

    @Test
    public void test1() {

        //截取员工的入职周年纪念日
        Date entryDate = new Date();

        // 使用 Calendar 获取日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entryDate);

        // 获取日
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH) + 1;

        String s = "Hi 【Mgr花名】,\n" +
                "\n" +
                "还有3个工作日，就是你的团队同学【员工花名】入职满【1】周年的日子【X月X日】（【周几】）啦！公司为TA准备了定制书签和纪念气球，到时候记得找前台（总部）or各区对接人（外区）领取并为TA送上周年祝福哈！";

        String repaceString = s.replace("【Mgr花名】", "【" + "cizhong" + "】")
                .replace("【员工花名】", "【" + "cizhong" + "】")
                .replace("【周几】", "周三")
                .replace("【X月X日】", month + "月" + day + "天");
        System.out.println(repaceString);
    }

    @Test
    public void test2() {
        String s = "10.10.50.79,172.168.175.183,0.0.0.0,192.168.128.1,0.0.0.0,0.0.0.0,0.0.0.0,0.0.0.0,0.0.0.0";
        String[] split = s.split(",");
        for (String string : split) {
            System.out.println(string);
        }
        System.out.println(StringUtils.isEmpty(s));
    }

    @Test
    public void test3() {
//        cn: hunyuan,mail: hunyuan@qunhemail.com,displayName: 混元
        String s1 = "cn: hunyuan";
        String substring1 = s1.substring(s1.indexOf(":") + 2);
        System.out.println(substring1);
        String s2 = "displayName: 混元";
        String substring2 = s2.substring(s2.indexOf(":") + 2);
        System.out.println(substring2);
    }

    /**
     * 测试判空字符串工具类
     */
    @Test
    public void test4() {
        System.out.println("".trim().isEmpty());
        System.out.println(" ".trim().isEmpty());
        System.out.println("你好".trim().isEmpty());
        System.out.println("".trim().isEmpty());
    }

    /**
     * 测试StringUtils的haseText方法
     */
    @Test
    public void test5() {
        System.out.println(StringUtils.hasText(null));
        System.out.println(StringUtils.hasText(""));
        System.out.println(StringUtils.hasText(" "));
        System.out.println(StringUtils.hasText("123"));
        System.out.println(StringUtils.hasText("  123"));
        System.out.println(StringUtils.hasText("  123   "));
        System.out.println(StringUtils.hasText("123  "));

    }

    @Test
    public void test6(){
        String specificationId="6NEcTowU558A00:2c49e928304d28fab384d76ff167abd1b859815b";
        String s="6NEcTowU558A00";
        System.out.println(specificationId.contains(s));
    }



}
