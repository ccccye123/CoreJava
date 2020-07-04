package com.company.base.chapter14;

public class ThreadUncaughtTest {
    public static void main(String[] args) {
        Runnable runnable = ()->{
          throw new RuntimeException("runtime exception");
        };

        Thread.setDefaultUncaughtExceptionHandler(((t, e) -> {
            System.out.println("线程默认的异常处理器");
        }));
        Thread thread = new Thread(runnable);
//        thread.setUncaughtExceptionHandler(((t, e) -> {
//            System.out.println("独立的异常处理器");
//        }));
        thread.start();
    }
}
