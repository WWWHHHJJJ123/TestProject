package com.whj.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {
        System.out.println(square(2));
        List<String> strings=new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        Collections.sort(strings);
    }

    public static int square(int num) {
        assert num > 0 : "Input parameter must be positive";
        return num * num;
    }


}
