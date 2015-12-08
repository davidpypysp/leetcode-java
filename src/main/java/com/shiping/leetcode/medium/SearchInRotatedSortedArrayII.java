package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/18.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length, mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(target == nums[mid]) return true;
            if(nums[left] == nums[mid] && nums[mid] == nums[right - 1]) {
                for(int i = left; i < right; i++) {
                    if(target == nums[i]) return true;
                }
                return false;
            }

            if(nums[left] <= nums[mid] && nums[mid] <= nums[right - 1]) {
                if(target > nums[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            else {
                if(target > nums[mid]) {
                    if(target >= nums[left] && nums[left] > nums[mid]) {
                        right = mid;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                else {
                    if(target <= nums[right - 1] && nums[right - 1] < nums[mid]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }
            }
        }
        return false;
    }
}
