package com.whj.LeetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/11/9 9:44
 * @Version 1.0
 */

public class Test11 {
    public static void main(String[] args) {

    }

    /**
     * 给定一个  无重复元素 的 有序 整数数组 nums 。
     * <p>
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     * <p>
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * <p>
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     *
     * @param nums
     * @param
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] + 1 != nums[i]) {
                result.add(String.valueOf(nums[start]));
                start=i;
            }else {

            }
        }

        return null;
    }
}
