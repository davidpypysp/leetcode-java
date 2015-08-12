package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/8.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = isSameHeight(root);
        if(height != 0) return (1 << height) - 1;
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int isSameHeight(TreeNode root) {// 0 not the same, else: height;
        int left_height = 0, right_height = 0;
        TreeNode node = root;
        while(node != null) {
            node = node.left;
            left_height++;
        }
        node = root;
        while(node != null) {
            node = node.right;
            right_height ++;
        }
        if(left_height == right_height) return left_height;
        else return 0;
    }

}
