package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/16/16.
 */
public class MaximumProductArray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int maxd[] = new int[len];
        int mind[] = new int[len];
        int ans = nums[0];
        maxd[0] = mind[0] = nums[0];
        for(int i = 1; i < len; i++) {
            maxd[i] = Math.max(maxd[i-1] * nums[i], mind[i-1] * nums[i]);
            maxd[i] = Math.max(maxd[i], nums[i]);
            mind[i] = Math.min(maxd[i-1] * nums[i], mind[i-1] * nums[i]);
            mind[i] = Math.min(mind[i], nums[i]);

            ans = Math.max(ans, maxd[i]);
        }
        return ans;
    }

}
