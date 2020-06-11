package com.company.base.chapter14;

public class MyRunnableThread implements Runnable {
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
