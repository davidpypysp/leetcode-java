package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/10.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int len = getLen(head);
        k = k % len;
        ListNode left = head, right = null, node = head;
        for(int i = 0; i < len - k - 1; i++) {
            node = node.next;
        }
        ListNode newhead = node.next;
        node.next = null;

        node = newhead;
        if(newhead == null) return head;
        for(int i = 0; i < k -1; i++) {
            node = node.next;
        }
        node.next = head;
        return newhead;
    }

    public int getLen(ListNode head) {
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
