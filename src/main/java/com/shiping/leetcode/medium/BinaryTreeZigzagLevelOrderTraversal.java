package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shipin on 2015/8/7.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null) return lists;

        boolean dir = true; // true is left to right, false is right to left

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(queue.isEmpty() == false) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            if(dir == true) {
                lists.add(list);
            }
            else {
                List<Integer> rlist = new ArrayList<Integer>();
                for(int i = list.size() - 1; i >=0; i--) {
                    rlist.add( list.get(i) );
                }
                lists.add(rlist);
            }
            dir = !dir;
        }

        return lists;
    }
}
