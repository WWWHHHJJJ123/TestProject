package com.whj.comm_structure;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearchBasicMethod1(int[] a, int target) {
        int i = 0, j = a.length - 1;        //设置指针和初值
        if (target < a[0]) {
            return i;
        } else if (target > a[a.length - 1]) {
            return j + 1;
        }
        while (i <= j) {                    //范围内有东西
            int m = (i + j) >>> 1;
//            int m = (int) (i + j)/2;
            if (target < a[m]) {               //目标在左边
                j = m - 1;
            } else if (target > a[m]) {         //目标在右边
                i = m + 1;
            } else {                         //找到了
                return m;
            }
        }
        return j + 1;
    }

    public static int binarySearchBasicMethod2(int[] a, int target) {
        if (target < a[0]) {
            return 0;
        } else if (target > a[a.length - 1]) {
            return a.length;
        }
        int i = Arrays.binarySearch(a, target);
        if (i < 0) {
            return Math.abs(i) - 1;
        } else {
            return Math.abs(i);
        }

    }

    /**
     * 寻找最左侧元素
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBasicMethodLeft(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
//            int m = (int) (i + j)/2;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 寻找最右侧元素
     *
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBasicMethodRight(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
//            int m = (int) (i + j)/2;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }

    public static void main(String[] args) {
        int[] array={1,2,7,8,9};
        System.out.println(binarySearchBasicMethod1(array, 7));
        System.out.println(binarySearchBasicMethod1(array,5));
    }


}
