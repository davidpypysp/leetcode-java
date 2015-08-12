package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/10.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode left = null, right = null, node = head, righthead = null;
        while(node != null) {
            if(node.val < x) {
                ListNode newnode = new ListNode(node.val);
                if(left == null) {
                    left = newnode;
                    head = left;
                }
                else {
                    left.next = newnode;
                    left = left.next;
                }
            }
            else {
                ListNode newnode = new ListNode(node.val);
                if(right == null) {
                    right = newnode;
                    righthead = right;
                }
                else {
                    right.next = newnode;
                    right = right.next;
                }
            }
            node = node.next;
        }
        if(left == null) return righthead;
        else {
            left.next = righthead;
            return head;
        }
    }
}
