package com.example.demo.Callable;

import java.util.concurrent.*;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 9:37
 */
public class GetContentTask implements Callable<String> {

    private String name;

    private Integer sleepTimes;

    public GetContentTask(String name, Integer sleepTimes) {
        this.name = name;
        this.sleepTimes = sleepTimes;
    }

    @Override
    public String call() throws Exception {
        // 假设这是一个比较耗时的操作
        Thread.sleep(sleepTimes * 1000);
        return "this is content : hello " + this.name;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        long startTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            GetContentTask getContentTask = new GetContentTask("micro_" + i, 10);
            completionService.submit(getContentTask);
        }
        System.out.println("已将任务提交给线程池");
        try {
            Thread.sleep(8000);
            System.out.println("已空闲8秒钟");
            Future<String> take = completionService.take();
            for (int i = 0; i < count; i++) {
                String s = take.get();
                System.out.println("s--" + s);
            }
            long entTime = System.currentTimeMillis();
            System.out.println("耗时:" + (entTime - startTime) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
