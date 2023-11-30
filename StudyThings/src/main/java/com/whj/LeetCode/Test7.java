package com.whj.LeetCode;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author JieSir
 * @Date 2023/9/11 14:03
 * @Version 1.0
 */

public class Test7 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Scanner out = new Scanner(System.in);
//        int ou = out.nextInt();
//        // 注意 hasNext 和 hasNextLine 的区别
//        for (int i = 0; i < ou; i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
        String[] s=new String[]{"abcd","adcb","acbd"};
        String[] strings = StringUtils.sortStringArray(s);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        List<String[]> strArray=new ArrayList<>();

    }


    /**
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * <p>
     * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {


        return true;
    }
}
