package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 5/25/16.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            total += i;
            sum += nums[i];
        }
        total += n;
        return total - sum;
    }
}
