package com.whj.LeetCode;

import java.util.Arrays;

/**
 * @Author JieSir
 * @Date 2023/8/31 18:32
 * @Version 1.0
 * 1768. 交替合并字符串
 */

public class Test2 {

    public static void main(String[] args) {

        String s = mergeAlternately("abcd", "pq");
        System.out.println(s);
    }

    /**
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     *
     * @param word1
     * @param word2
     * @return
     */
    public static String mergeAlternately(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int i = 0, j = 0;
        StringBuffer sb=new StringBuffer();
        while (i<m||j<n){
            if (i<m){
                sb.append(word1.charAt(i));
                i++;
            }
            if (j<n){
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return String.valueOf(sb);
    }
}
