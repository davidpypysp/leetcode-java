package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by davidpy on 5/28/16.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        TreeNodeVal treenodeval = dfs(root);
        return Math.max(treenodeval.withRoot, treenodeval.withoutRoot);
    }

    public TreeNodeVal dfs(TreeNode root) {
        TreeNodeVal treenodeval = new TreeNodeVal(root);
        treenodeval.withRoot = root.val;
        if(root.left == null && root.right == null) {
            return treenodeval;
        }


        if(root.left != null) {
            TreeNodeVal left = dfs(root.left);
            treenodeval.withRoot += left.withoutRoot;
            treenodeval.withoutRoot += Math.max(left.withRoot, left.withoutRoot);
        }

        if(root.right != null) {
            TreeNodeVal right = dfs(root.right);
            treenodeval.withRoot += right.withoutRoot;
            treenodeval.withoutRoot += Math.max(right.withRoot, right.withoutRoot);
        }
        return treenodeval;

    }

    class TreeNodeVal {
        TreeNode root;
        int withRoot;
        int withoutRoot;
        TreeNodeVal(TreeNode root) {
            this.root = root;
            this.withRoot = 0;
            this.withoutRoot = 0;

        }
    }
}
