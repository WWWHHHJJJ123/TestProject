package com.whj.lambda;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/3
 * @描述
 */
public class Test {


    public static void main(String[] args) {
//        Cal cal = new Cal() {
//            @Override
//            public int add(int a, int b) {
//                return a + b;
//            }
//        };
//        System.out.println(cal.add(1,2));


        Cal cal = (int a, int b) -> {
            return a + b;
        };
        System.out.println(cal.add(1, 2));
    }

    interface Cal {
        int add(int a, int b);
    }


}
