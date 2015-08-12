package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;
import org.w3c.dom.NodeList;

/**
 * Created by shipin on 2015/8/9.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode right = swapPairs(head.next.next);
        ListNode temp = head;
        head = head.next;
        head.next = temp;
        head.next.next = right;
        return head;
    }
}
