package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipingci on 7/27/16.
 */
public class BinaryTreeMaximumPathSum {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;

    }

    public int maxPath(TreeNode root) {
        if(root == null) return 0;
        int max = root.val;
        int leftMax = maxPath(root.left);
        int rightMax = maxPath(root.right);
        if(leftMax < 0) leftMax = 0;
        if(rightMax < 0) rightMax = 0;
        max += Math.max(leftMax, rightMax);
        ans = Math.max(ans, root.val + leftMax + rightMax);
        return max;

    }
}
