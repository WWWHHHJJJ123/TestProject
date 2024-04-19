package com.whj.comm_structure;

import java.util.Collections;

/**
 * @Author WHJ
 * @Date 2024/4/18 17:55
 * @Description: 选择排序
 * @Version 1.0
 */
public class SelectSorting {
    public static void main(String[] args) {
        int[] sort = sort(getArray());
        for (int i : sort) {
            System.out.println(i);
        }

    }

    public static int[]  sort(int[] str) {

        if (str == null || str.length == 0) {
            return str;
        }
        for (int i = 0; i < str.length; i++) {
            int min = i;
            for (int j = i; j < str.length; j++) {
                if (str[min] > str[j]) {
                    min = j;
                }
            }
            // 将最小值放在索引为i的位置
            if (min != i) {
                int temp = str[i];
                str[i] = str[min];
                str[min] = temp;
            }
        }
        return str;
    }

    public static int[] getArray() {
        int[] array = {3, 1, 5, 2, 8, 4, 10};
        return array;
    }
}
