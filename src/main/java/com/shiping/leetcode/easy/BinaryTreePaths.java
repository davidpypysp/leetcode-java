package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 2/28/16.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
        dfs(list, root, Integer.toString(root.val));
        return list;
    }

    void dfs(List<String> list, TreeNode root, String s) {
        if(root.left == null & root.right == null) {
            list.add(s);
        }
        if(root.left != null) {
            dfs(list, root.left, s + "->" + Integer.toString(root.left.val));
        }

        if(root.right != null) {
            dfs(list, root.right, s + "->" + Integer.toString(root.right.val));
        }

    }
}
