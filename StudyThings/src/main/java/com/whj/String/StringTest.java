package com.whj.String;

import org.junit.jupiter.api.Test;

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
                .replace("【X月X日】", month +"月"+ day + "天");
        System.out.println(repaceString);
    }
}
