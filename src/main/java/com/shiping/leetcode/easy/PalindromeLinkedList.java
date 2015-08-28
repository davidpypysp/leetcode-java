package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipin on 2015/8/28.
 */
public class PalindromeLinkedList {
    ListNode cur = null;

    public boolean isPalindrome(ListNode head) {
        cur = head;
        return f(head);
    }

    public boolean f(ListNode head) {
        if(head == null) return true;
        if(f(head.next) == false) return false;
        if(head.val != cur.val) {
            return false;
        }
        cur = cur.next;
        return true;
    }

}
