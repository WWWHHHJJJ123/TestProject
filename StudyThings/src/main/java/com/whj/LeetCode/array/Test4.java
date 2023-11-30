package com.whj.LeetCode.array;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author JieSir
 * @Date 2023/9/1 17:10
 * @Version 1.0
 * 字母异位词
 */

public class Test4 {
    public static void main(String[] args) {
        int[] array={1,1,2};
        System.out.println(removeDuplicates(array));
    }


    /**
     *     给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     *
     * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
     *
     * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
     * 返回 k 。
     */

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int i=0;
        int[] newArray=new  int[set.size()];
        for (Integer integer : set) {
            newArray[i]=integer;
            i++;
        }
        int j=0;
        Arrays.sort(newArray);
        for (int i1 = 0; i1 < newArray.length; i1++) {
            nums[j]=newArray[j];
            j++;
        }
        return set.size();
    }
}
