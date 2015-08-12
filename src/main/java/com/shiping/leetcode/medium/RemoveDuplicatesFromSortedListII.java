package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/10.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode node = head, pre = null;
        boolean dup = false;
        while(node != null) {
            if(node.next != null && node.next.val == node.val) {
                dup = true;
                node.next = node.next.next;
            }
            else {
                if(dup == true) {
                    dup = false;
                    if(pre == null) {
                        head = node.next;
                    }
                    else {
                        pre.next = node.next;
                    }
                }
                else {
                    pre = node;
                }
                node = node.next;
            }
        }
        return head;
    }
}
