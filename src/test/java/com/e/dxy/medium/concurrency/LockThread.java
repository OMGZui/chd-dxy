package com.e.dxy.medium.concurrency;

import java.text.SimpleDateFormat;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 9/21/22 6:44 PM
 */
public class LockThread {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();

    public static class MasterYi implements Runnable{
        @Override
        public void run() {
            synchronized (lockA){
                System.out.println("MasterYi get lockA");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("MasterYi wait lockB");

                synchronized (lockB){
                    System.out.println("MasterYi get lockA and lockB");
                }
            }
        }
    }

    public static class Garen implements Runnable{
        @Override
        public void run() {
            synchronized (lockB){
                System.out.println("Garen get lockB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Garen wait lockA");

                synchronized (lockA){
                    System.out.println("Garen get lockA and lockB");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread masterYiThread = new Thread(new MasterYi());
        Thread garenThread = new Thread(new Garen());

        masterYiThread.start();
        garenThread.start();
    }

}
