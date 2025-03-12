package com.whj.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.*;

@Slf4j
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task("601857"));
        System.out.println(future.get());
        es.shutdown();
    }

    @Test
    public void test1(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                // 核心线程数
                3,
                // 最大线程数
                5,
                // 空闲线程最大存活时间
                60L,
                // 空闲线程最大存活时间单位
                TimeUnit.SECONDS,
                // 等待队列及大小
                new ArrayBlockingQueue<>(100),
                // 创建新线程时使用的工厂
                Executors.defaultThreadFactory(),
                // 当线程池达到最大时的处理策略
//                new ThreadPoolExecutor.AbortPolicy()          // 抛出RejectedExecutionHandler异常
                new ThreadPoolExecutor.CallerRunsPolicy()       // 交由调用者的线程执行
//                new ThreadPoolExecutor.DiscardOldestPolicy()  // 丢掉最早未处理的任务
//                new ThreadPoolExecutor.DiscardPolicy()        // 丢掉新提交的任务
        );

        // 总共5个任务
        for (int i = 1; i <= 5; i++) {
            int taskIndex = i;
            executor.execute(() -> {
                System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行任务 " + taskIndex);

                // 每个任务耗时1秒
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

}
