package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/4.
 */
public class ValidateBinarySearchTree {
    int value;
    boolean first = true;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if(root.left != null)
        {
            if(dfs(root.left) == false) {
                return false;
            }
        }

        if(first == false && root.val <= value) {
            return false;
        }
        first = false;
        value = root.val;

        if(root.right != null) {
            if(dfs(root.right) == false) {
                return false;
            }
        }
        return true;
    }

}
