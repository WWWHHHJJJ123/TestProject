package com.whj.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/8/21 19:01
 * @Version 1.0
 */

public class Test7 {
    public static void main(String[] args) {
        int array[] =new int[]{1,1,2};
        int i = removeDuplicates(array);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0&&nums.length==1){
            return nums.length;
        }
        List<Integer> numList=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            numList.add(nums[i]);
        }
        Object[] array = numList.stream().distinct().toArray();
        return array.length;


    }
}
