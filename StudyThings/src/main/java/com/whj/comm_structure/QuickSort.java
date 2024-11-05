package com.whj.comm_structure;

import java.util.Arrays;

/**
 * @author admin
 * @date 2024-10-22
 */
public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        //设置两个变量，代表需要交换的值
        int l = start;
        int r = end;
        //用于交换
        int temp;
        //中轴值
        int center = arr[start];

        while (l < r) {
            //找到这个值，在左边找到大于或者等于中轴的值
            while (arr[l] < center) {
                l++;
            }
            //在右边找到小于等于中轴的值
            while (arr[r] > center) {
                r--;
            }
            //如果l>=r就直接退出不进行交换
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完当左边的值中轴时，就将另右边的值-1；防止两个值同时为中轴值，会陷入死循环，一直进行交换
            if (arr[l] == center) {
                r--;
            }

        }
        //当退出循环的时候，分别对左边和右边进行快速排序
        if (l == r) {
            l++;
            r--;
        }
        if (start < r) {
            quickSort(arr, start, r);
        }
        if (end > l) {
            quickSort(arr, l, end);
        }
    }


    public static void main(String[] args) {
        int[] array ={9,8,7,6,5,4,3,2,1};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
