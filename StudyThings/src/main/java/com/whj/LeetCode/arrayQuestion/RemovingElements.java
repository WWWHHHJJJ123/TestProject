package com.whj.LeetCode.arrayQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CiZhong
 * @date 2024-11-13
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 *
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 *
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class RemovingElements {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        removeElement(nums,3);
    }
    public static int removeElement(int[] nums, int val) {
        if (nums.length==0){
            return 0;
        }
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                values.add(nums[i]);
            }
        }
        for (int i = 0; i < values.size(); i++) {
            nums[i] = values.get(i);
        }
        return values.size();
    }
}
