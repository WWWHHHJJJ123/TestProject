package com.whj.LeetCode.array;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author JieSir
 * @Date 2023/9/1 16:07
 * @Version 1.0
 */

public class Test3 {
    public static void main(String[] args) {

//        List<Integer> arrayList = new ArrayList<>();
//        arrayList.add(3);
//        arrayList.add(2);
//        arrayList.add(3);
//        System.out.println(Collections.binarySearch(arrayList, 3));
        int[] array = {3, 2, 4};
        int[] ints = twoSum(array, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * @param nums   v
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
//        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; ++i) {
//            if (hashtable.containsKey(target - nums[i])) {
//                return new int[]{hashtable.get(target - nums[i]), i};
//            }
//            hashtable.put(nums[i], i);
//        }
//        return new int[0];

    }

}
