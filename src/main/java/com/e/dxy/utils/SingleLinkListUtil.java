package com.e.dxy.utils;

public class SingleLinkListUtil {

    public ListNode head;

    public int size;

    public SingleLinkListUtil() {
        head = null;
        size = 0;
    }

    public SingleLinkListUtil(ListNode listNode, int size) {
        this.head = listNode;
        this.size = size;
    }


    public static ListNode createList(int[] nums) {
        SingleLinkListUtil singleLinkListUtil = new SingleLinkListUtil();
        for (int i = 0; i < nums.length; i++) {
            singleLinkListUtil.insertNth(nums[i], singleLinkListUtil.size);
        }
        return singleLinkListUtil.head;
    }

    // 插入链表的某个位置
    public void insertNth(int data, int position) {

        checkBounds(position, 0, size);

        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < position - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public static ListNode searchValueBySortListNode(ListNode head, int val) {
        ListNode findListNode;
        while (true) {
            if (head.val == val) {
                findListNode = head;
                break;
            }
            head = head.next;
        }
        return findListNode;
    }

    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

}
