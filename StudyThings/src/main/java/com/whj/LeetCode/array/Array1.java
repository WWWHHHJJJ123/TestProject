package com.whj.LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/10/18 16:54
 * @Version 1.0
 * 27. 移除元素
 */

public class Array1 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
//        int i = 0;
//        int zeroNum = 0;
//        for (int num : nums) {
//            if (num == val) {
//                nums[i] = 0;
//                zeroNum++;
//            }
//            i++;
//        }
//        Arrays.sort(nums);
//
//        return nums.length - zeroNum;
        int zeroNum = 0;
        List<Integer> list=new ArrayList<>();
        for (int num : nums) {
            if (num==val){
                list.add(0);
                zeroNum++;
            }else {
                list.add(num);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
        return nums.length - zeroNum;
    }
}
