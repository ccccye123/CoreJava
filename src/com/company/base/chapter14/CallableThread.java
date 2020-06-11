package com.company.base.chapter14;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程:"+Thread.currentThread().getId());
        for (int i=0;i<10;i++){
            Thread.sleep(1000);
        }

        return 2;
    }
}
