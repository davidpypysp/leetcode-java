package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;


/**
 * Created by shipin on 2015/8/10.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new ReorderList().reorderList(head);

        ListNode node = head;
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }




    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode node = head;
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }

        node = head;
        int mid = (len % 2 == 0) ? len/2 : len/2 + 1;
        for(int i = 0; i < mid - 1; i++) {
            node = node.next;
        }

        ListNode right = node.next;
        node.next = null;
        right = reverseList(right);
        ListNode left = head;

        while(left != null) {
            ListNode temp = left.next;
            left.next = right;
            if(right != null) right = right.next;
            left = left.next;
            if(temp != null) {
                left.next = temp;
            }
            if(left != null) left = left.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, node = head;
        while(node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            if(temp == null) head = node;
            node = temp;
        }
        return head;
    }

}
