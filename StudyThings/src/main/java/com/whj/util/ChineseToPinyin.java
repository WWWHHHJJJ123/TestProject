package com.whj.util;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author CiZhong
 * @date 2024-10-30
 */
public class ChineseToPinyin {
    public static void main(String[] args) {
        String chinese = "长乐"; // 替换为你想转换的中文字符串
        String pinyin = convertToPinyin(chinese);
        System.out.println(pinyin); // 输出拼音
    }

    public static String convertToPinyin(String chinese) {
        StringBuilder pinyinBuilder = new StringBuilder();

        for (char character : chinese.toCharArray()) {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(character);
            if (pinyinArray != null && pinyinArray.length > 0) {
                pinyinBuilder.append(pinyinArray[0].replaceAll("[0-9]", "")); // 去掉声调
            }
        }

        return pinyinBuilder.toString(); // 返回拼音结果
    }
}