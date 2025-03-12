package com.whj.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author CiZhong
 * @date 2024-10-31
 */
public class DateTest {

    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("--------------------------");
        LocalDate localDate = now.toLocalDate();
        System.out.println(localDate);
    }
    @Test
    public void test2() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println("--------------------------");
        LocalDate MAX = LocalDateTime.MAX.toLocalDate();
        LocalDate MIN = LocalDateTime.MIN.toLocalDate();
        System.out.println(MAX);
        System.out.println(MIN);
    }

    @Test
    public void test3() {
        LocalDate today = LocalDate.now();
        LocalDate newDay = LocalDate.of(today.getYear(), 11, 15);
        int dayOfWeekValue = newDay.getDayOfWeek().getValue();
        // 获取今天的日期
        String weekValue = "";
        switch (dayOfWeekValue) {
            case 1: // 这里直接写值
                weekValue = "一";
                break;
            case 2:
                weekValue = "二";
                break;
            case 3:
                weekValue = "三";
                break;
            case 4:
                weekValue = "四";
                break;
            case 5:
                weekValue = "五";
                break;
            case 6:
                weekValue = "六";
                break;
            case 7:
                weekValue = "日";
                break;
            default:
                weekValue = "无效的日期";
                break;
        }
        System.out.println(weekValue);
    }

}
