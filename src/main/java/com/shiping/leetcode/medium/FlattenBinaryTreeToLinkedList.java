package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipin on 2015/8/7.
 */
public class FlattenBinaryTreeToLinkedList {
    List<TreeNode> list = new ArrayList<TreeNode>();

    public void flatten(TreeNode root) {
        if(root == null) return;
        dfs(root);
        TreeNode node = root;
        for(int i = 1; i < list.size(); i++) {
            node.left = null;
            node.right = list.get(i);
            node = node.right;
        }
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
