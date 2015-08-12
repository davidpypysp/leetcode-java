package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

public class IsSameTree {
	
	public static void main(String[] args) {
		
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


