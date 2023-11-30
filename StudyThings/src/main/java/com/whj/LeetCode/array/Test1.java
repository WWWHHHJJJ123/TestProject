package com.whj.LeetCode.array;

import java.util.Arrays;

/**
 * @Author JieSir
 * @Date 2023/8/27 13:44
 * @Version 1.0
 * 合并两个数组
 */

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},2);
    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，
     * 应忽略。nums2 的长度为 n 。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int[] ints = Arrays.copyOf(nums1, m + n);
        for (int i = m; i < ints.length; i++) {
            ints[m] = nums2[j];
            j++;
        }
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
  
    }

}

