package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(root == null) return ans;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int num = q.size();
			for(int i = 0; i < num; i++) {
				TreeNode cur = q.remove();
				list.add(cur.val);
				if(cur.left != null) q.add(cur.left);
				if(cur.right != null) q.add(cur.right);
			}
			ans.add(list);
		}
		List<List<Integer>> ansii = new ArrayList<List<Integer>>();
		for(int i = 0; i < ans.size(); i++) {
			ansii.add(ans.get(ans.size() - i - 1));
		}
		
		return ansii;
	}

}
