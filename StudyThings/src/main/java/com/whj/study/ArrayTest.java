package com.whj.study;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {
        System.out.println(square(2));
    }

    public static int square(int num) {
        assert num > 0 : "Input parameter must be positive";
        return num * num;
    }


}
