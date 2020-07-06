package com.company.base.chapter14;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private Lock lock = new ReentrantLock();

    public void lock1(){
        lock.lock();
        try{
            System.out.println("lock1");
        }finally{
            lock.unlock();
        }
    }

    public void lock2(){
        lock.lock();
        try{
            System.out.println("lock2");
        }finally{
            lock.unlock();
        }
    }
}
