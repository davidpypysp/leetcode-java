package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/9.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }

        if(len == 1) {
            return head;
        }

        ListNode left = head, right = head;
        for(int i = 0; i < len / 2; i++) {
            left = right;
            right = right.next;
        }
        left.next = null;
        left = head;

        left = sortList(left);
        right = sortList(right);
        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode node = null, pre = null, head = null;
        while( left != null || right != null ) {
            if(left != null && right != null) {
                if(left.val < right.val) {
                    node = left;
                    left = left.next;
                }
                else {
                    node = right;
                    right = right.next;
                }
            }
            else if(left != null && right == null) {
                node = left;
                left = left.next;
            }
            else if(left == null && right != null) {
                node = right;
                right = right.next;
            }

            if(pre == null) {
                pre = node;
                head = node;
            }
            else {
                pre.next = node;
                pre = pre.next;
            }
        }
        return head;
    }

}
