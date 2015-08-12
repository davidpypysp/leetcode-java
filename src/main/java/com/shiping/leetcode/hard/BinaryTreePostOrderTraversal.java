package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePostOrderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(stack.isEmpty() == false) {
			TreeNode cur = stack.peek();
			if(cur.left != null) {
				stack.push(cur.left);
				cur.left = null;
				continue;
			}
			if(cur.right != null) {
				stack.push(cur.right);
				cur.right = null;
				continue;
			}
			list.add(cur.val);
			stack.pop();
		}
		
		return list;
		
	}

}
