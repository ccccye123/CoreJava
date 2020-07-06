package com.company.base.chapter14;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Runnable target = ()-> {
//            System.out.println("hello");
//        };
//        Thread th1 = new Thread(target);
//
//        // 为th1线程安装处理器
//        th1.setUncaughtExceptionHandler((t,e)->{
//            System.out.println("未捕获的异常处理器");
//        });
//
//        // 为所有线程安装默认的处理器
//        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
//            System.out.println("未捕获的异常处理器");
//        });
//
////        th1.getThreadGroup().uncaughtException();
//        th1.start();

        // 可重入锁
        LockTest lockTest = new LockTest();
        lockTest.lock1();
        lockTest.lock2();

//        // 创建手动锁
//        Lock lock = new ReentrantLock();
//        lock.lock();
//        //lock.tryLock(5, TimeUnit.SECONDS;
//        try{
//            System.out.println("获得了锁");
//        }catch(Exception e){
//
//        }finally{
//            lock.unlock();
//        }
//
//        ThreadLocal local = new ThreadLocal<String>();
//
//        local.set("sss");
//        System.out.println(local.get());
//
//        // 创建线程池的7种方法
//        // 1 创建可缓存的线程池   无可用线程自动创建，线程池可不限大
//       ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//       cachedThreadPool.execute(new Runnable() {
//           @Override
//           public void run() {
//               System.out.println("子线程获取:"+local.get());
//               local.set("abcd");
//
//               System.out.println("子线程："+Thread.currentThread().getId());
//           }
//       });
//        System.out.println(local.get());
//
//       // 2 创建定长线程池，超出的线程在队列等待
//        ExecutorService fixedThreadPool =  Executors.newFixedThreadPool(3);
//        fixedThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("fixed thread 子线程："+Thread.currentThread().getId());
//            }
//        });
//
//        // 3 创建定长，可周期性任务执行
//        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 3, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("周期性线程池"+Thread.currentThread().getId());
//            }
//        }, 1, 3, TimeUnit.SECONDS);
//
//        // 4 创建单线程的线程池， 只有1个线程，任务队列可以指定  FIFO  LIFO
//        ExecutorService singleThreadService = Executors.newSingleThreadExecutor();
//        singleThreadService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("single thread 子线程："+Thread.currentThread().getId());
//            }
//        });
//
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2 // 最少线程资源数量
//                , 16 // 最多线程资源数量
//                , 1000 // 线程空闲自动销毁时间,具体时间还要看时间单位
//                , TimeUnit.SECONDS  // 时间单位  秒
//                , new LinkedBlockingQueue()  // 任务队列类型   链表
//                ,Executors.defaultThreadFactory() // 线程工厂,一般使用默认的
//                , new ThreadPoolExecutor.AbortPolicy());  // 拒绝任务时的处理策略  丢弃任务报异常


//
//        System.out.println("主线程:"+Thread.currentThread().getId());
//
//        CallableThread call = new CallableThread();
//        FutureTask<Integer> ft = new FutureTask<>(call);
//
//        System.out.println("a");
//        Thread th = new Thread(ft);
//        th.start();
//        System.out.println("b");
//        System.out.println(ft.get());  // 如果线程没有返回将阻塞
//
//        Thread.sleep(100);
//        th.wait();
//

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
