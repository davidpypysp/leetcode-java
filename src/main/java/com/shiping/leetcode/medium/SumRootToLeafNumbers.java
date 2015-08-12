package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/7.
 */
public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int val) {
        val = val * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if(root.left != null) {
            dfs(root.left, val);
        }
        if(root.right != null) {
            dfs(root.right, val);
        }

    }

}
