package com.whj.LeetCode.array;

import java.math.MathContext;
import java.util.*;

/**
 * @Author JieSir
 * @Date 2023/9/11 13:16
 * @Version 1.0
 */

public class Test6 {
    public static void main(String[] args) {
        List<Boolean> booleans = kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        System.out.println(booleans);
    }

    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * <p>
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     */

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> status=new ArrayList<>();


        int maxNum=0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]>maxNum){
                maxNum=candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            candies[i]=candies[i]+extraCandies;
            if (candies[i]<maxNum){
                status.add(false);
            }else {
                status.add(true);
            }
        }
        return status  ;
    }

}
