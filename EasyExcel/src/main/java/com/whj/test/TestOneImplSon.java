package com.whj.test;

/**
 * @Author JieSir
 * @Date 2023/7/30 16:22
 * @Version 1.0
 */

public class TestOneImplSon extends TestOneImpl{

    @Override
    public void test1() {

        System.out.println("哈哈哈哈");
    }

    public static void main(String[] args) {
        TestOneImpl testOne=new TestOneImplSon();
        testOne.test1();
        System.out.println(testOne.test2());

        System.out.println(testOne.test3("123"));

    }

}
