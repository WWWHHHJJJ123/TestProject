package com.whj.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
