package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shipin on 2015/8/5.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        bfs(root);
    }

    public void bfs(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            int len = queue.size();
            TreeLinkNode pre = null;
            for(int i = 0; i < len; i++) {
                TreeLinkNode node = queue.poll();
                TreeLinkNode left = node.left;
                TreeLinkNode right = node.right;
                if(left == null) break;
                if(pre != null) pre.next = left;
                left.next = right;
                pre = right;
                queue.add(left);
                queue.add(right);
            }
        }
    }


}
