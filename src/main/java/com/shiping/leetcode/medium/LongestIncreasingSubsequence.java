package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/6/16.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(d[j] + 1 > d[i]) {
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        int max = d[0];
        for(int i = 0; i < n; i++) {
            max = Math.max(max, d[i]);
        }
        return max;

    }
}
