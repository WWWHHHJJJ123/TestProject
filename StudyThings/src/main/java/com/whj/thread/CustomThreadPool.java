package com.whj.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author CiZhong
 * @date 2025-03-04
 */
public class CustomThreadPool {
    public static void main(String[] args) {
        // 配置线程池参数
        int corePoolSize = 5;         // 核心线程数（常驻线程）
        int maximumPoolSize = 10;     // 最大线程数（核心线程 + 临时线程）
        long keepAliveTime = 30L;     // 空闲线程存活时间（单位：秒）
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20); // 任务队列容量

        // 创建自定义线程池
        ThreadPoolExecutor customExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue
        );

    }
}
