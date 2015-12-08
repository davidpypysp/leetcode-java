package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if(nums[mid] < target) return mid+1;
        return mid;
    }
}
