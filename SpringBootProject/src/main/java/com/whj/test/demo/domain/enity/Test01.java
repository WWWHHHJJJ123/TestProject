package com.whj.test.demo.domain.enity;

/**
 * @创建人 JieSi
 * @创建时间 2023/7/11
 * @描述 单例模式（Singleton)   单例模式（Singleton
 * 私有的构造方法使得Test01完全被封闭起来 实例化工作是自己内部的事务
 * private static final 修饰 保证了 INSTANCE是私有的 ,不可见的不可访问的,static保证了静态性,在类被加载进内存时,就已经初始化 ,final保证INSTANCE是常量,是不能被修改的
 * 外部只要调用公共的方法TEST01.getINSTANCE就可以获得唯一的实例对象了
 */
public class Test01 {
    private static final Test01  INSTANCE=new Test01();

    private  Test01(){

    }

    public static Test01 getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Test01.getINSTANCE().hashCode());
            }).start();
        }
    }
}
