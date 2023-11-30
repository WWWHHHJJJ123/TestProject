package com.whj.learn;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author JieSir
 * @Date 2023/8/19 9:40
 * @Version 1.0
 */

public class Test4 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {9, 5, 8,7};
        int[] ints = Arrays.copyOf(array1, (array1.length + array2.length));
        System.arraycopy(array2, 0, ints, array1.length, array2.length);
        Arrays.sort(ints);
        //1 2 3 4 5 8 9

        if (ints.length%2==0){
            int mid = ints.length / 2;
            int result = ints[mid-1] + ints[mid];
            int i = (int) ((double)result / 2);
            System.out.println(i);
        }else {
            int i = ints.length / 2;

            System.out.println(ints[i]);
        }
    }
}
