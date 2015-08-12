package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/9.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode head2 = new ListNode(head.val);
        while(head.next != null) {
            head = head.next;
            ListNode node = head2, pre = null;
            while(node != null && head.val >= node.val) {
                pre = node;
                node = node.next;
            }
            ListNode newnode = new ListNode(head.val);
            if(pre == null) {
                head2 = newnode;
            }
            else {
                pre.next = newnode;
            }
            newnode.next = node;
        }
        return head2;

    }
}
