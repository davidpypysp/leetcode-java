package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null) return null;
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(stack.isEmpty() == false) {
			TreeNode cur = stack.peek();
			if(cur.left != null) {
				stack.push(cur.left);
				cur.left = null;
				continue;
			}
			list.add(cur.val);
			stack.pop();
			if(cur.right != null) {
				stack.push(cur.right);
			}
			
		}
		return list;
	}

}
