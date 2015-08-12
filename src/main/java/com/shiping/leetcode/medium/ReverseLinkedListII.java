package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/9.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head, left = null;
        for(int i = 1;i < m; i++) {
            left = node;
            node = node.next;
        }
        ListNode pre = null, right = null, tail = node;
        for(int i = m; i <= n; i++) {
            right = node.next;
            node.next = pre;
            pre = node;
            node = right;
        }
        if(left != null) {
            left.next = pre;
            tail.next = right;
            return head;
        }
        else {
            tail.next = right;
            return pre;
        }
    }
}
