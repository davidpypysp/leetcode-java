package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/7.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
