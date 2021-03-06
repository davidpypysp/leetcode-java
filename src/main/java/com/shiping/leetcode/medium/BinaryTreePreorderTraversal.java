package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(cur.val);
			if(cur.right != null) stack.push(cur.right);
			if(cur.left != null) stack.push(cur.left);
		}
		return list;
		
	}

}
