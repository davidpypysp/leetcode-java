package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shipin on 2015/8/5.
 */
public class BinaryTreeRightSideView {
    List<Integer> list;

    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<Integer>();
        bfs(root);
        return list;
    }


    public void bfs(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            int len = queue.size();
            TreeNode pre = null;
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                pre = node;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(pre.val);
        }
    }


}
