package com.e.dxy.utils;

public class ArrayStackUtil {

    // 数组
    public String[] items;

    // 元素个数
    public int count;

    // 栈大小
    public int n;

    public ArrayStackUtil(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    // 入栈
    public boolean push(String item) {
        // 空间不够
        if (count == n){
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }


    // 出栈
    public String pop() {
        if (count == 0) {
            return null;
        }
        String t = items[count - 1];
        count--;
        return t;
    }
}
