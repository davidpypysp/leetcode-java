package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

public class SymmetricTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = null;
		System.out.println(isSymmetric(root));
		
	}
	
	public static boolean isSymmetric(TreeNode root) {
		TreeNode nr = rotateTree(root);
		return isSameTree(nr, root);
		
	}
	
	public static TreeNode rotateTree(TreeNode root) {
		if(root == null) return null;
		TreeNode nr = new TreeNode(root.val);
		nr.left = rotateTree(root.right);
		nr.right = rotateTree(root.left);
		return nr;
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p != null && q != null) {
			if(p.val != q.val) return false;
			if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) return true;
		}
		return false;
	}

}
