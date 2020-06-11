package com.company.base.chapter14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("主线程:"+Thread.currentThread().getId());

        CallableThread call = new CallableThread();
        FutureTask<Integer> ft = new FutureTask<>(call);

        System.out.println("a");
        Thread th = new Thread(ft);
        th.start();
        System.out.println("b");
        System.out.println(ft.get());  // 如果线程没有返回将阻塞

        //        Runnable runnable = new MyRunnableThread();
//        Thread th = new Thread(runnable);
//        System.out.println(th.getState());
//        th.setPriority(Thread.NORM_PRIORITY);
//        th.start();
//        System.out.println(th.getState());
//
//        th.join();

//        Thread th = new MyThread();
//        System.out.println(th.getState());
//        th.start();
//        System.out.println(th.getState());
//        Thread th2 = new MyThread();
//        th2.start();
//        System.out.println(th2.getState());
//
//        th.join();
//        th2.join();
    }
}
