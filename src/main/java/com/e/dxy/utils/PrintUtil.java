package com.e.dxy.utils;

public class PrintUtil {

    // 数组输出
    public static void printArray(int[] arr){
        for (int a : arr){
            System.out.println(a);
        }
    }

    public static void printSingleList(ListNode head){
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
