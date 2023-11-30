package com.whj.LeetCode;

/**
 * @Author JieSir
 * @Date 2023/9/5 10:34
 * @Version 1.0
 */

public class Test5 {
    public static void main(String[] args) {

        String str1 = "AAAAAAAAA", str2 = "AAACCC";
//        String s = gcdOfStrings(str1, str2);
//        System.out.println(s);
        String s = gcdOfStrings(str1, str2);
        System.out.println(s);
    }

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    public static boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

}
