package com.whj.learn;

import java.util.Arrays;

/**
 * @Author JieSir
 * @Date 2023/9/25 13:41
 * @Version 1.0
 */

public class Test9 {
    public static void main(String[] args) {
        int[] array=new int[]{1,4,6,9,2,3,5};
        Arrays.sort(array);
        for (int i : array) {
            System.out.println(i);
        }

    }
}
