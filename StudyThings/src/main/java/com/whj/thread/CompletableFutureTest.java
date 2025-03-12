package com.whj.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author CiZhong
 * @date 2025-03-04
 */
public class CompletableFutureTest {

    ThreadPoolExecutor customExecutor = createCustomThreadPool(); // 创建上述自定义线程池

    private static ThreadPoolExecutor createCustomThreadPool() {
        return new ThreadPoolExecutor(
                5,
                10,
                30,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20)
        );
    }
    
    @Test
    public void test1() {


        for (int i = 0; i < 20; i++) {
            int finalI = i;
            CompletableFuture.runAsync(()->{
                System.out.println(finalI);
            },customExecutor);
        }


        System.out.println("主线程继续执行");
    }
}
