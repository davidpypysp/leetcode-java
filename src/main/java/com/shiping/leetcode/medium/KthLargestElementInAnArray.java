package com.shiping.leetcode.medium;

import java.util.Arrays;

/**
 * Created by shipingci on 7/25/16.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
