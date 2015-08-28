package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/19.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        int left = 0, right = 0, sum = 0;
        while(left < nums.length && right < nums.length) {
            while(sum < s && right < nums.length) {
                sum += nums[right++];
            }
            while(sum >= s && left <= right) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
