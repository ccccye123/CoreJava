package com.company.base.chapter14;

/**
 * 创建线程方式1，继承Thread
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getId());
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
