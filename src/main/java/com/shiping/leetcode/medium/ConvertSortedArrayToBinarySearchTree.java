package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/8.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if(left >= right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid);
        node.right = dfs(nums, mid+1, right);
        return node;
    }
}
