package com.whj.study;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @Author WHJ
 * @Date 2024/4/20 17:35
 * @Description: TODO
 * @Version 1.0
 */
public class StopWatchStudy {
        public static void main(String[] args) throws InterruptedException {
            StopWatch stopWatch = new StopWatch("测试秒表");

            stopWatch.start("暂停100毫秒");
            Thread.sleep(100 * 1);
            stopWatch.stop();

            stopWatch.start("暂停200毫秒");
            Thread.sleep(100 * 2);
            stopWatch.stop();

            stopWatch.start("暂停300毫秒");
            Thread.sleep(100 * 3);
            stopWatch.stop();

            stopWatch.setKeepTaskList(true); //是否构建TaskInfo信息
            Arrays.stream(stopWatch.getTaskInfo()).forEach(sw ->
                    System.out.println(sw.getTaskName()+" "+
                            sw.getTimeMillis()+" "+sw.getTimeSeconds()));
            // 在start()方法和stop()方法间时，isRunning()返回true
            System.out.println(stopWatch.isRunning());
            System.out.println(stopWatch.prettyPrint());//打印详细信息
            System.out.println(stopWatch.shortSummary());//打印简要信息
        }
}
