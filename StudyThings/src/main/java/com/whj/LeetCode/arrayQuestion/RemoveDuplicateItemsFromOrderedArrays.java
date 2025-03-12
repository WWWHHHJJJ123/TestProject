package com.whj.LeetCode.arrayQuestion;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author CiZhong
 * @date 2024-11-08
 * <p>
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 */
public class RemoveDuplicateItemsFromOrderedArrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        int k = removeDuplicates1(nums); // 调用


    }

    /**
     * 解法1 使用set的天然幂等性来获取数据，再将数据重复赋值给nums
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();  // 使用 LinkedHashSet 保证插入顺序
        for (int num : nums) {
            set.add(num);
        }
        // 使用增强的 for 循环遍历 Set，保证顺序
        int i = 0;
        for (Integer value : set) {
            nums[i++] = value;
        }

        return set.size();
    }

    /**
     * 解法2
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

}
