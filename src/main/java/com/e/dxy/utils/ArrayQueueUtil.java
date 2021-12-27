package com.e.dxy.utils;

public class ArrayQueueUtil {

    public String[] items;
    public int n = 0;

    public int head = 0;
    public int tail = 0;


    public ArrayQueueUtil(int n) {
        this.items = new String[n];
        this.n = n;
    }


    // 入队
    public boolean enQueue(String s){
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }

        items[tail] = s;
        tail++;
        return true;
    }

    // 出队
    public String deQueue(){
        if (head == tail) {
            return null;
        }

        String s = items[head];
        head++;
        return s;
    }


}
