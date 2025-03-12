package com.whj.LocalDate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author CiZhong
 * @date 2024-12-30
 */
public class LocalDateTest {

    @Test
    public void test1(){
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(43);
        System.out.println(localDate);
    }
}
