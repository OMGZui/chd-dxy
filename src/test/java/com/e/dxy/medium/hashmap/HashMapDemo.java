package com.e.dxy.medium.hashmap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
//        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("1", "2");
        map.put("3", "2");
        map.put("4", "6");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (String key : map.keySet()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("key" + key);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                map.put("5", "8");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        thread2.start();
    }
}
