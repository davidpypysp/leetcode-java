package com.shiping.leetcode.easy;

/**
 * Created by davidpy on 4/19/16.
 */
public class RangeSumQueryImmutable {
    static int[] d;
    public void NumArray(int[] nums) {
        if(nums.length == 0) return;
        d = new int[nums.length];
        d[0] = nums[0];
        for(int i = 1; i < d.length; i++) {
            d[i] = d[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return d[j];
        else {
            return d[j] - d[i - 1];
        }
    }
}
