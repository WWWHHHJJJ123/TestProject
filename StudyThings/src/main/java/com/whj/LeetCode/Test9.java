package com.whj.LeetCode;

import java.util.Arrays;

/**
 * @Author JieSir
 * @Date 2023/10/7 16:13
 * @Version 1.0
 */

public class Test9 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    public static void main(String[] args) {
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1]<=1){

            }else {
                return i;
            }
        }
        return nums.length;
    }
}
