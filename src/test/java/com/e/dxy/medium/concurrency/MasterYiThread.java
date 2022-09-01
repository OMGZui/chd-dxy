package com.e.dxy.medium.concurrency;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/30/22 6:08 PM
 */
public class MasterYiThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm Master Yi");
    }
}
