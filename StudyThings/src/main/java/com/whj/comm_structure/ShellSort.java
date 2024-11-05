package com.whj.comm_structure;

/**
 * @author admin
 * @date 2024-10-21
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        ShellSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void ShellSort(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            //插入排序将1换成gap
            for (int i = gap; i < a.length; i++) {
                for (int j = i; j - gap >= 0; j -= gap) {
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        a[j] = a[j - gap];
                        a[j - gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
