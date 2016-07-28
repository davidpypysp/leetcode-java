package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipingci on 7/27/16.
 */
public class RecoverBinarySearchTree {
    TreeNode pre = null;
    TreeNode l = null, r = null;

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int tmp = l.val;
        l.val = r.val;
        r.val = tmp;
    }


    public void inOrderTraversal(TreeNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);

        if(pre != null && root.val < pre.val) {
            if(l == null) {
                l = pre;
                r = root;
            } else {
                r = root;
            }
        }
        pre = root;
        inOrderTraversal(root.right);
    }


}
