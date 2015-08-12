package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/9.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int d[] = new int[nums.length + 1];
        d[nums.length] = 0;
        int consecutive = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            consecutive += nums[i];
            if(i == nums.length - 1) d[i] = nums[i];
            else d[i] = Math.max(d[i + 1], consecutive);
            if(consecutive < 0) consecutive = 0;
        }
        return d[0];
    }
}

