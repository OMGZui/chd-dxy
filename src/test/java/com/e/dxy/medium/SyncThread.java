package com.e.dxy.medium;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 6/28/22 10:15 PM
 */
class SyncThread implements Runnable {

    @Override
    public void run() {
        sync();
//        System.out.println(Thread.currentThread().getName() + "_Sync: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//        synchronized (this) {
//            try {
//                System.out.println(Thread.currentThread().getName() + "_Sync_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//                Thread.sleep(2000);
//                System.out.println(Thread.currentThread().getName() + "_Sync_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
    public synchronized static void sync() {
        System.out.println(Thread.currentThread().getName() + "_Sync: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_Sync_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Sync_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
