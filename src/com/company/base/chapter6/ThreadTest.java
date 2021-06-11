package com.company.base.chapter6;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(512);
        RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(poolSize, poolSize,
                0, TimeUnit.SECONDS,
                queue,
                policy);

//        executorService.execute();

        ExecutorService service = Executors.newFixedThreadPool(2);

    }
}
