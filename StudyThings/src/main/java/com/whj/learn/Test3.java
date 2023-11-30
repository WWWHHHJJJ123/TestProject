package com.whj.learn;

import java.util.*;

/**
 * @Author JieSir
 * @Date 2023/8/13 9:37
 * @Version 1.0
 */

public class Test3 {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(6);
        set.add(11);
        set.add(51);
        set.add(65);
        set.add(0);
        System.out.println(set);
        System.out.println("=================");
        Map<Integer,String> map=new TreeMap<>();
        map.put(1,"111");
        map.put(3,"333");
        map.put(2,"222");
        map.put(6,"666");
        map.put(0,"000");
        System.out.println(map);

    }
}
