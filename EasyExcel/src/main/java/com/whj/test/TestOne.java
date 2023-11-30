package com.whj.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author JieSir
 * @Date 2023/7/30 16:21
 * @Version 1.0
 */

public interface TestOne {

    void test1();

    String test2();

    default String test3(String name) {
        return name;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(22);
        arrayList.add(11);
        arrayList.add(44);
        arrayList.add(null);
        arrayList.add(4);
        lists.add(arrayList);
        List<Integer> arrayList2 = JSON.parseArray(JSON.toJSONString(arrayList), Integer.class);
        arrayList2.add(55);
        lists.add(arrayList2);
        List<Integer> arrayList3 = JSON.parseArray(JSON.toJSONString(arrayList), Integer.class);
        arrayList3.add(99);
        arrayList3.add(-2);
        lists.add(arrayList3);
        //将子集合抽上来形成一个大集合
        List<Integer> collect = lists.stream().flatMap(item -> item.stream().filter(Objects::nonNull))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
//输出：[1, 3, 22, 11, 44, 4, 1, 3, 22, 11, 44, 4, 55, 1, 3, 22, 11, 44, 4, 99, -2]

}
