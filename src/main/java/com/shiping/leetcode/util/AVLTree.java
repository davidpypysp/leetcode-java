package com.shiping.leetcode.util;

/**
 * Created by shipin on 2015/8/8.
 */
public class AVLTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        for(int i = 0; i <nums.length; i++) {
            root = insertNode(nums[i], root);
        }
        return root;

    }

    public TreeNode insertNode(int key, TreeNode root) {
        if(root == null) {
            root = new TreeNode(key);
            return root;
        }

        if(key < root.val) {
            root.left = insertNode(key, root.left);
            if(height(root.left) - height(root.right) >= 2) {
                if(key < root.left.val) {
                    root = llRotation(root);
                }
                else {
                    root = lrRotation(root);
                }
            }
        }
        else {
            root.right = insertNode(key, root.right);
            if(height(root.right) - height(root.left) >= 2) {
                if(key >= root.right.val) {
                    root = rrRotation(root);
                }
                else {
                    root = lrRotation(root);
                }
            }
        }
        return root;
    }


    public int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public TreeNode llRotation(TreeNode root) {
        TreeNode l = root.left;
        root.left = l.right;
        l.right = root;
        return l;
    }

    public TreeNode rrRotation(TreeNode root) {
        TreeNode r = root.right;
        root.right = r.left;
        r.left = root;
        return r;
    }

    public TreeNode lrRotation(TreeNode root) {
        root.left = rrRotation(root.left);
        return llRotation(root);
    }

    public TreeNode rlRotation(TreeNode root) {
        root.right = llRotation(root.right);
        return rrRotation(root);
    }
}
