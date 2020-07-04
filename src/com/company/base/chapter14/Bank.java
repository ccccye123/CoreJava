package com.company.base.chapter14;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, int balance) {
        accounts = new double[n];
        Arrays.fill(accounts, balance);
    }

    public synchronized void transfer(int from, int to, double amount){
        if (accounts[from] < amount) return;

        System.out.println("Thread ID:"+Thread.currentThread().getId());
        accounts[from] -= amount;
        System.out.printf("%10.2f,from %d to %d\r\n", amount, from, to);
        accounts[to] += amount;

        System.out.println("total:"+totalBalance());
    }

    private double totalBalance(){
        double total = 0;
        for (double a : accounts)
            total += a;
        return total;
    }

    public int size(){
        return accounts.length;
    }
}
