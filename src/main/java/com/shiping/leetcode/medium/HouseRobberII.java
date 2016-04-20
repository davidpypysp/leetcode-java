package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/17/16.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int d[] = new int[n];

        // not contain the last
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n - 1; i++) {
            d[i] = Math.max(nums[i] + d[i - 2], d[i - 1]);
        }
        int ans1 = d[n - 2];

        //not contain the first
        d[1] = nums[1];
        d[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++) {
            d[i] = Math.max(nums[i] + d[i - 2], d[i - 1]);
        }
        int ans2 = d[n - 1];

        return Math.max(ans1, ans2);

    }

}
