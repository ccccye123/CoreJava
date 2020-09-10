package com.company.other.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    /**悲观锁调用方式**/
    public synchronized void method1(){
        // 操作同步资源
    }
    // 可重入锁
    private ReentrantLock lock = new ReentrantLock();
    public void method2(){
        lock.lock();
        // 操作同步资源
        lock.unlock();
    }

    /**乐观锁调用**/
    private static AtomicInteger aint = new AtomicInteger();  // concurrent包
    public static void main(String[] args) {
        // 内部使用CAS  compare and swap
        aint.incrementAndGet();  // 自增1

    }
}
