package com.whj.LeetCode.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author JieSir
 * @Date 2023/10/19 17:11
 * @Version 1.0
 */

public class Test10 {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 9};
        int[] ints = plusOne(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
//        int[] ints = Arrays.copyOf(array, array.length + 1);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public static int[] plusOne(int[] digits) {
        if (Objects.isNull(digits)) {
            return digits;
        }
        int[] ints = null;
        if (digits[digits.length - 1] == 9) {
            ints = Arrays.copyOf(digits, digits.length + 1);
        }else {
            ints=new int[digits.length];
        }
        for (int i = ints.length-1; i > 0; i--) {
            if (digits[i] == 9) {
                ints[i + 1] = 0;
            }else {
                ints[i+1]=digits[i]+1;
            }
        }
        return ints;
    }
}
