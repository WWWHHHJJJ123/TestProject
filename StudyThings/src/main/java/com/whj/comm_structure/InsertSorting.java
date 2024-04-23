package com.whj.comm_structure;

/**
 * @Author WHJ
 * @Date 2024/4/22 14:52
 * @Description: 插入排序
 * @Version 1.0
 */
public class InsertSorting {

    public static void main(String[] args) {
        int[] sort = sort(getArray());
        for (int i : sort) {
            System.out.println(i);
        }
    }
    public static int[] sort(int[] str) {
        for (int i = 1; i < str.length; i++) {
            int temp = str[i];
            int j = i - 1;
            while (j >= 0) {
                if (str[j] > temp) {
                    str[j + 1] = str[j];
                    j--;
                } else {
                    break;
                }
            }
            str[j + 1] = temp;
        }
        return str;
    }

    public static int[] getArray() {
        int[] array = {3, 5, 2, 8, 1, 4, 10};
        return array;
    }

}
