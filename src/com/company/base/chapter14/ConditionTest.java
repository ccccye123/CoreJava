package com.company.base.chapter14;

import java.io.Console;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 多线程条件对象
public class ConditionTest {
    public static void main(String[] args) {
        Obj obj = new Obj();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new ThreadA(obj,lock,condition,0)).start();
        new Thread(new ThreadA(obj,lock,condition,1)).start();


    }
}

class Obj{
    public int num = 0;
}

// 打印偶数
   class ThreadA implements Runnable{
    private Obj obj;
    private Lock lock;
    private Condition condition;
    private int flag;

       public ThreadA(Obj obj, Lock lock, Condition condition, int flag) {
           this.obj = obj;
           this.lock = lock;
           this.condition = condition;
           this.flag = flag;
       }

       @Override
       public void run() {
           while (obj.num < 100){
               lock.lock();
               try{
                   Long id = Thread.currentThread().getId();
                   while (obj.num%2!=flag)
                       condition.await();
//                   if (obj.num%2 != flag){
//                       condition.await();
//                   }

                   System.out.println(Thread.currentThread().getId() + ",flag,"+ flag + "  :" +obj.num);
                   obj.num++;
//                   Thread.sleep(100);
                   condition.signalAll();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally{
                   lock.unlock();
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
   }
