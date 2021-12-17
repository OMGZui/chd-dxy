package com.e.dxy.leetcode.easy.list;

import com.e.dxy.utils.ListNode;
import com.e.dxy.utils.PrintUtil;
import com.e.dxy.utils.SingleLinkListUtil;

public class ReverseLinkedList206 {

    public static ListNode reverseList111(ListNode head) {
        ListNode pre = head, cur = null;

        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    public static ListNode reverseList222(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList222(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    public static void main(String[] args) {
        ListNode listNode = SingleLinkListUtil.createList(new int[]{1, 2, 3, 4, 5});
//        ListNode reverseList111 = reverseList111(listNode);
//        PrintUtil.printSingleList(reverseList111);

        ListNode reverseList222 = reverseList222(listNode);
        PrintUtil.printSingleList(reverseList222);
    }
}
