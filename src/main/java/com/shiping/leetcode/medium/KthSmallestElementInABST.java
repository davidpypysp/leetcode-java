package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/5.
 */
public class KthSmallestElementInABST {
    int cnt = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }


    public boolean dfs(TreeNode root, int k) {
        if(root == null) return false;
        if(dfs(root.left, k) == true) return true;
        cnt++;
        if(cnt == k) {
            ans = root.val;
            return true;
        }
        if(dfs(root.right, k) == true) return true;
        return false;
    }
}
