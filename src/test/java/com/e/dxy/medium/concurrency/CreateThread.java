package com.e.dxy.medium.concurrency;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/30/22 5:40 PM
 */
public class CreateThread {
    public static void main(String[] args) {

        // MasterYi
        Thread MasterYi = new MasterYiThread();
        MasterYi.setName("MasterYi");

        // Yasuo
        Thread Yasuo = new Thread(() -> System.out.println("I'm Yasuo"));
        Yasuo.setName("Yasuo");

        // Garen
        Thread Garen = new Thread(new GarenThread(), "GarenThread");

        MasterYi.start();
        Yasuo.start();
        Garen.start();

        System.out.println("bye");
    }
}
