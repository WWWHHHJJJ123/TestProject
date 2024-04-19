package com.whj.comm_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author WHJ
 * @Date 2024/4/17 11:38
 * @Description: 冒泡排序
 * @Version 1.0
 */
public class BubbleSorting {

    public static int[] getArray() {
        int[] array = {3, 5, 2, 8, 1, 4, 10};
        return array;
    }

    public static void main(String[] args) {
        // {3, 5, 2, 8,1 4, 10}
        int[] ints = bubbleSort(getArray());
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
