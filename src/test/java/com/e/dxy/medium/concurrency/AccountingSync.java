package com.e.dxy.medium.concurrency;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountingSync implements Runnable {

    static volatile int i = 0;

    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
            log.info("i=" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync sync1 = new AccountingSync();
        AccountingSync sync2 = new AccountingSync();
        Thread thread1 = new Thread(sync1);
        Thread thread2 = new Thread(sync2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
