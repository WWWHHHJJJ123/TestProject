package com.whj.comm_structure;

/**
 * @author: CiZhong
 * 创建日期: 2024/8/27
 * 创建时间: 9:36
 */
public class SwapExclusive {
    public static void main(String[] args) {
        int[] values = {156, 222222};
        System.out.println("a: " + values[0] + ", b: " + values[1]);
        System.out.println("--------------------------");
        swap(values);
        System.out.println("a: " + values[0] + ", b: " + values[1]);
    }

    static void swap(int[] array) {
        array[0] = array[0] ^ array[1];
        array[1] = array[0] ^ array[1];
        array[0] = array[0] ^ array[1];
    }
}
