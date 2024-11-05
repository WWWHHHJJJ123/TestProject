package com.whj.comm_structure;

import java.util.Arrays;

/**
 * @author CiZhong
 * @date 2024-10-28
 */
public class MergeSort {
    //归并排序
    public static void mergeSort(int[] array, int left, int right){
        if (left >= right) {
            return;
        }
        int mid = (left+right) / 2;
        //向左递归分解
        mergeSort(array, left, mid);
        //向右递归分解
        mergeSort(array, mid + 1, right);
        //排序 合并
        merge(array, left, right, mid);
    }
    //排序 合并子序列
    public static void merge(int[] array, int start, int end, int mid){
        int s1 = start; //初始化s1，左边有序序列的初始索引
        int s2 = mid + 1; //初始化s2，右边有序序列的初始索引
        int k = 0; //指向tmp数组的当前索引
        int[] tmp =new int[end -start +1];
        while (s1 <= mid && s2 <= end) {
            if(array[s1] <= array[s2]) {
                tmp[k++] =array[s1++];
            }else {
                tmp[k++] =array[s2++];
            }
        }
        //将剩余子序列中的元素挪到新数组中
        while (s1 <= mid) {
            tmp[k++] =array[s1++];
        }
        while (s2 <= end) {
            tmp[k++] =array[s2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            //i + start 是防止拷贝第二段子序列时，覆盖第一段，且达不到想到的效果
            array[i+start] =tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        mergeSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}