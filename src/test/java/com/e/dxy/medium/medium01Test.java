package com.e.dxy.medium;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 6/28/22 10:05 PM
 */
public class medium01Test{

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread F_thread1 = new Thread(new SyncThread(), "F_thread1");
        Thread F_thread2 = new Thread(new SyncThread(), "F_thread2");
        Thread F_thread3 = new Thread(syncThread, "F_thread3");
        Thread F_thread4 = new Thread(syncThread, "F_thread4");
        F_thread1.start();
        F_thread2.start();
        F_thread3.start();
        F_thread4.start();
    }
}
