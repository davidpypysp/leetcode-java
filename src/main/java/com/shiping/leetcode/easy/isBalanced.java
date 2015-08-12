package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

public class isBalanced {
	public boolean isBalanced(TreeNode root) {
		if(ib(root) == -1) return false;
		return true;
	}
	
	public int ib(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int l = 0, r = 0;
		if(root.left != null) l = ib(root.left);
		if(l == -1) return -1;
		if(root.right != null) r = ib(root.right);
		if(r == -1) return -1;
		if(l == r || l == r + 1 || l == r - 1) return Math.max(l, r) + 1;
		return -1;
	}

}
