package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shipin on 2015/8/5.
 */
public class PopulatingNextRightPointersInEachNodeII {
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
                if(pre != null) pre.next = node;
                pre = node;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
    }
}
