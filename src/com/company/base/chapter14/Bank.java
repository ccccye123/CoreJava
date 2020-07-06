package com.company.base.chapter14;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Lock lock = new ReentrantLock();
    private final double[] accounts;

    public Bank(int n, int balance) {
        accounts = new double[n];
        Arrays.fill(accounts, balance);
    }

    public void transfer(int from, int to, double amount){

        lock.lock();
        try {
            if (accounts[from] < amount) return;

            System.out.println("Thread ID:" + Thread.currentThread().getId());
            accounts[from] -= amount;
            System.out.printf("%10.2f,from %d to %d\r\n", amount, from, to);
            accounts[to] += amount;

            System.out.println("total:" + totalBalance());
        }
        finally{
            lock.unlock();
        }
    }

    private double totalBalance(){
        lock.lock();
        try {
        double total = 0;
        for (double a : accounts)
            total += a;
        return total;
        }
        finally{
            lock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }
}
