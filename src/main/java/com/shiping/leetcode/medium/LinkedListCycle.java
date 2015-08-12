package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shipin on 2015/8/9.
 */
public class LinkedListCycle {
    //Map<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();

    public boolean hasCycle(ListNode head) {
        /*
        ListNode node = head;
        while(node != null) {
            map.put(node, true);
            node = node.next;
            if(map.containsKey(node) == true) return true;
        }
        return false;
        */
        return chase(head);
    }

    public boolean chase(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == null) return false;
            if(fast == slow) return true;
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}
