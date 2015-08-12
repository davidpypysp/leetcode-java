package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shipin on 2015/8/8.
 */
public class PathSumII {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return lists;
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, sum, list);
        return lists;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list) {
        List<Integer> nlist = new ArrayList<Integer>(list);
        sum -= root.val;
        nlist.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == 0) lists.add(nlist);
            return;
        }
        if(root.left != null) dfs(root.left, sum, nlist);
        if(root.right != null) dfs(root.right, sum, nlist);
    }
}
