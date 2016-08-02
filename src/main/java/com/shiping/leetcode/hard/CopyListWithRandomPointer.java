package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shipingci on 7/30/16.
 */
public class CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };


    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode res = null;
        RandomListNode node = head;
        RandomListNode node2 = null;
        RandomListNode pre = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(node != null) {
            node2 = new RandomListNode(node.label);
            map.put(node, node2);
            if(pre == null) {
                res = node2;
            } else {
                pre.next = node2;
            }
            pre = node2;
            node = node.next;
        }
        node = head;
        node2 = res;
        while(node != null) {
            node2.random = map.get(node.random);
            node = node.next;
            node2 = node2.next;
        }
        return res;
    }
}
