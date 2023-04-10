package com.e.dxy.medium.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AccountingSyncClass implements Runnable {
//    static int i = 0;
    static AtomicInteger i = new AtomicInteger();

    @Override
    public void run() {
        synchronized (AccountingSyncClass.class){
            for (int j = 0; j < 1000000; j++) {
//                i++;
                i.incrementAndGet();
                log.info("i=" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSyncClass sync1 = new AccountingSyncClass();
        AccountingSyncClass sync2 = new AccountingSyncClass();
        Thread thread1 = new Thread(sync1);
        Thread thread2 = new Thread(sync2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
