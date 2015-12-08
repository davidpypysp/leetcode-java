package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/30.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length;
        int ans = 0;
        if(l == r - 1 ||nums[l] < nums[r - 1]) {
            return nums[l];
        }

        while(l < r) {
            if(l == r - 1) {
                ans = nums[l];
                break;
            }
            int mid = (l + r) / 2;
            if(nums[l] <= nums[mid - 1] && nums[mid] <= nums[r - 1]) {
                ans = nums[mid];
                break;
            }
            else if(nums[l] <= nums[mid - 1] && nums[mid] > nums[r - 1]) {
                l = mid;
            }
            else if(nums[l] > nums[mid - 1] && nums[mid] <= nums[r - 1]) {
                r = mid;
            }
        }
        return ans;
    }
}
