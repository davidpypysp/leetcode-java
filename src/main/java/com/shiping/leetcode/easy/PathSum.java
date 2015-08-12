package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		else if(root.left == null && root.right == null && sum == root.val) return true;
		else if(root.left != null && hasPathSum(root.left, sum - root.val)) return true;
		else if(root.right != null && hasPathSum(root.right, sum - root.val)) return true;
		return false;
	}

}
