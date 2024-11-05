package com.whj.regex;

import java.util.regex.Pattern;

/**
 * @author admin
 * @date 2024-10-21
 */
public class PasswordValidator {
    // 密码正则表达式
    private static final String PASSWORD_PATTERN =
            "^(?=(?:.*[A-Z])?(?:.*[a-z])?(?:.*[0-9])?(?:.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])?.{6,20}$)(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])|(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])|(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])|(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])).*$";



    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    /**
     * 校验密码是否符合要求
     *
     * @param password 密码字符串
     * @return true：符合要求；false：不符合要求
     */
    public static boolean validate(String password) {
        return pattern.matcher(password).matches();
    }

    public static void main(String[] args) {
//        String testPassword = "WhJ...1029@.wHj945";
//
//        if (!validate(testPassword)) {
//            System.out.println("密码不符合要求！");
//        }

        String regex = "^[\\u4e00-\\u9fa5]+$|^[a-zA-ZüÜ\\s]+$";

        String str="Jennie";

        System.out.println(Pattern.matches(regex, str));

        if (Pattern.matches(regex, str)) {
            System.out.println(str.matches("^[\\u4e00-\\u9fa5]+$") ? "中文--1" : "字母--2");
        } else {
            System.out.println(str.matches("包含其他字符"));
        }
    }
}
