package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/30.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int l = 0, r = nums.length;
        while(l != r - 1) {
            int mid = (l + r) / 2;
            if(nums[mid - 1] < nums[mid]) {
                l = mid;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}
