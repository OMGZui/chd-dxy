package com.e.dxy.leetcode.easy.list;

import com.e.dxy.utils.ListNode;
import com.e.dxy.utils.PrintUtil;
import com.e.dxy.utils.SingleLinkListUtil;

public class ReverseLinkedList206 {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = head, cur = null;

        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode listNode = SingleLinkListUtil.createList(new int[]{1, 2, 3, 4, 5});
        ListNode reverseList = reverseList(listNode);
        PrintUtil.printSingleList(reverseList);
    }
}
