package com.whj.test;

/**
 * @Author JieSir
 * @Date 2023/7/30 16:22
 * @Version 1.0
 */

public class TestOneImpl implements TestOne{
    @Override
    public void test1() {
        System.out.println("word");
    }

    @Override
    public String test2() {
        return "Hello";
    }

    @Override
    public String test3(String name) {
        return name+"123哈哈哈哈";
    }
}
