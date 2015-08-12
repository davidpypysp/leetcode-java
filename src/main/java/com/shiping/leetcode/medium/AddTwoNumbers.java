package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/11.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;

        int addOne = 0;
        ListNode node = null, pre = null, head = null;
        while(l1 != null || l2 != null) {
            node = new ListNode(0);
            if(l1 != null && l2 != null) {
                node.val = l1.val + l2.val;
            }
            else if(l1 != null && l2 == null) {
                node.val = l1.val;
            }
            else if(l1 == null && l2 != null) {
                node.val = l2.val;
            }
            node.val += addOne;
            if(node.val >= 10) {
                addOne = 1;
                node.val = node.val % 10;
            }
            else {
                addOne = 0;
            }

            if(pre == null) {
                pre = node;
                head = pre;
            }
            else {
                pre.next = node;
                pre = pre.next;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(addOne == 1) {
            pre.next = new ListNode(1);
        }
        return head;

    }
}
