package com.whj.comm_structure;

/**
 * @Author WHJ
 * @Date 2024/4/22 14:52
 * @Description: 插入排序
 * @Version 1.0
 */
public class InsertSorting {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // 移动已排序部分的元素
            while (j >= 0 && arr[j] > key)  {
                arr[j + 1] = arr[j];
                j--;
            }
            // 插入当前元素
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        insertionSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
