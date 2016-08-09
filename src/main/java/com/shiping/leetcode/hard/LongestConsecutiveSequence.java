package com.shiping.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shipingci on 8/9/16.
 */
public class LongestConsecutiveSequence {
    Map<Integer, Node> map = new HashMap<Integer, Node>();

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 1;
        for(int num : nums) {
            Node node = new Node(num);
            map.put(num, node);
        }

        for(int num : nums) {
            if(map.containsKey(num-1)) {
                Node node = map.get(num);
                Node node1 = map.get(num-1);
                if(!isSameSet(node, node1)) {
                    union(node, node1);
                    if(res < getCount(node)) {
                        res = getCount(node);
                    }
                }
            }
            if(map.containsKey(num+1)) {
                Node node = map.get(num);
                Node node1 = map.get(num+1);
                if(!isSameSet(node, node1)) {
                    union(node, node1);
                    if(res < getCount(node)) {
                        res = getCount(node);
                    }
                }
            }

        }
        return res;

    }

    class Node {
        public int val;
        public int parent;
        public int count;
        Node(int val) {
            this.val = val;
            this.parent = val;
            count = 1;
        }
    }

    boolean isSameSet(Node node1, Node node2) {
        return find(node1) == find(node2);
    }

    Node find(Node node) {
        if(node.val == node.parent) return node;
        Node parentNode =  find(map.get(node.parent));
        node.parent = parentNode.val;
        node.count = parentNode.count;
        return parentNode;

    }

    void union(Node node1, Node node2) {  // new parent is node1's parent
        Node parentNode1 = find(node1);
        Node parentNode2 = find(node2);
        parentNode2.parent = parentNode1.parent;
        parentNode1.count += parentNode2.count;
    }

    int getCount(Node node) {
        Node nodeParent = find(node);
        return nodeParent.count;
    }
}
