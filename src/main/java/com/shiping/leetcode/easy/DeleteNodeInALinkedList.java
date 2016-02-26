package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by davidpy on 16/2/25.
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        System.out.println("hello");

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
