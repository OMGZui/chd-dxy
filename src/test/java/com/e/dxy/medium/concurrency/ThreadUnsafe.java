package com.e.dxy.medium.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnsafe {

    private int cnt = 0;

    private synchronized void add(){
        cnt++;
    }

    private int getCnt(){
        return cnt;
    }


    public static void main(String[] args) throws InterruptedException {
        //  1000 个线程同时对 cnt 执行自增操作
        final int threadSize = 1000;
        ThreadUnsafe threadUnsafe = new ThreadUnsafe();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                threadUnsafe.add();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println(threadUnsafe.getCnt());
    }
}
