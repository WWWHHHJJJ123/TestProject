package com.whj.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JieSir
 * @Date 2023/10/17 15:59
 * @Version 1.0
 */

public class Test12 {
    public static void main(String[] args) {
        convertToTitle(1);
    }

    public static String convertToTitle(int columnNumber) {
        int result = 0;
        int i=0;
        while (result / 26 == 0) {
            result = columnNumber / 26;
            i++;
        }


        return null;
    }
}
