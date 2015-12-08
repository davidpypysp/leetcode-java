package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/17.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                if(nums[left] < nums[right - 1]) {
                    left = mid + 1;
                }
                else {
                    if(nums[left] > nums[mid] && target > nums[right - 1]) {
                        right = mid;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
            else {
                if(nums[left] < nums[right - 1]) {
                    right = mid;
                }
                else {
                    if(nums[mid] > nums[right - 1] && target < nums[left]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }
            }
        }
        return -1;
    }
}
