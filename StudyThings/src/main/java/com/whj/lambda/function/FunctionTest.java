package com.whj.lambda.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author CiZhong
 * @date 2025-02-19
 */
public class FunctionTest {
    private static final List<String> nameList = Arrays.asList("张三", "李四", "王五", "刘欢");

    @Test
    void testFunction() {
        functionMethod(nameList::indexOf);
        functionMethod(e -> nameList.indexOf(e) + 1);
    }

    private void functionMethod(Function<String, Integer> function) {
        Integer index = function.apply("王五");
        System.out.println("王五" + "排在第" + index);
    }
}
