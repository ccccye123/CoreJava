package com.company.base.chapter14;

public class BankTest {
    private static final int ACCOUNT_COUNT = 100;
    private static final int INIT_BALANCE = 1000;
    private static final double MAX_AMOUNT = 1000;
    private static final int DELAY = 10;

    public static void main(String[] args) {

        Bank bank = new Bank(ACCOUNT_COUNT, INIT_BALANCE);
        for (int i=0;i<ACCOUNT_COUNT;i++){
            int from = i;
            Runnable runnable = ()->{
                while(true) {
                    int to = (int) (Math.random() * bank.size());
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(from, to, amount);
                    try {
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(runnable).start();
        }

    }
}
