package com.e.dxy.medium.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReenterLock implements Runnable {

    static int i = 0;
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            lock.lock();
            try{
                i++;
                log.info("i=" + i);
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock sync1 = new ReenterLock();
        Thread thread1 = new Thread(sync1);
        Thread thread2 = new Thread(sync1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
