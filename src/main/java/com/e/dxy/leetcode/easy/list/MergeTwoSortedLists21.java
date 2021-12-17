package com.e.dxy.leetcode.easy.list;

import com.e.dxy.utils.ListNode;
import com.e.dxy.utils.PrintUtil;
import com.e.dxy.utils.SingleLinkListUtil;

public class MergeTwoSortedLists21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;

        return preHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = SingleLinkListUtil.createList(new int[]{1, 2, 4});
        ListNode listNode2 = SingleLinkListUtil.createList(new int[]{1, 1, 3, 4, 40});


        ListNode res = mergeTwoLists(listNode1, listNode2);
        PrintUtil.printSingleList(res);
    }
}
