package com.whj.LeetCode.arrayQuestion;

/**
 * @author CiZhong
 * @date 2024-11-13
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class SearchInsertLocation {


    public static void main(String[] args) {

    }
    public static int searchInsert(int[] nums, int target) {

        if (nums.length==1){
            if (nums[0]>=target){
                return 0;
            }else {
                return 1;
            }
        }
        if (nums[0]>target){
            return 0;
        }
        if (nums[nums.length-1]<target){
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
                return i;
            }
        }

        return 0;
    }
}
