package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shipin on 2015/8/5.
 */
public class BSTIterator {
    List<Integer> list;
    Iterator<Integer> it;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        dfs(root);
        it = list.iterator();
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return it.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return it.next();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
