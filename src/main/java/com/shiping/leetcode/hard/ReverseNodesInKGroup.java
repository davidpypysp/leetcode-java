package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.ListNode;

import java.util.Stack;

/**
 * Created by shipingci on 7/30/16.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        new ReverseNodesInKGroup().reverseKGroup(l1, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode left = null;
        ListNode node = head;
        ListNode res = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        int i = 0;
        while(node != null) {
            stack.push(node);
            node = node.next;
            i++;
            if(i == k) {
                ListNode pre = null;
                while(!stack.isEmpty()) {
                    ListNode tmp = stack.pop();
                    if(pre == null) {
                        if(left == null) {
                            res = tmp;
                        } else {
                            left.next = tmp;
                        }
                    } else {
                        pre.next = tmp;
                    }
                    pre = tmp;
                }
                pre.next = node;
                left = pre;
                i = 0;
            }
        }
        return res;
    }
}
