package com.whj.array_test;

import com.whj.array_test.domain.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


    @Test
    public void test() {
        List<Item> originalList = new ArrayList<>(Arrays.asList(new Item("A"), new Item("B"), new Item("C")));
        List<Item> filterList = new ArrayList<>(Arrays.asList(new Item("B"), new Item("C")));

        List<Item> filteredList = originalList.stream()
                .filter(item -> filterList.stream().noneMatch(f -> f.getName().equals(item.getName())))
                .collect(Collectors.toList());

        // 输出结果
        filteredList.forEach(item -> System.out.println(item.getName())); // 输出:
    }

}
