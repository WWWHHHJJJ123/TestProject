package com.whj.LeetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author JieSir
 * @Date 2023/10/19 14:52
 * @Version 1.0
 * 35. 搜索插入位置
 */


public class Test9 {
    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        int i = searchInsert(array, 2);

        System.out.println(i);

    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return i;
            } else if (nums[i]>target) {
                return i;
            }
        }
        return nums.length;
    }
}
