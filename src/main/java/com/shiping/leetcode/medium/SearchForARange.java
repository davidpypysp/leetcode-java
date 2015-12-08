package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/22.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length, mid = 0;
        int min = -1, max = -1;
        boolean find = false;
        while(left < right) {
            mid = (left + right) / 2;
            if(target == nums[mid]) {
                find = true;
                break;
            }
            else if(target < nums[mid]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        if(find == true) {
            int l = left, r = right;
            while(l < r) {
                int m = (l + r) / 2;
                if(target > nums[m]) {
                    l = m + 1;
                }
                else if(target == nums[m]) {
                    if(m == l || nums[m - 1] != target) {
                        min = m;
                        break;
                    }
                    else {
                        r = m;
                    }
                }
            }
            l = left;
            r = right;
            while(l < r) {
                int m = (l + r) / 2;
                if(target < nums[m]) {
                    r = m;
                }
                else if(target == nums[m]) {
                    if(m == r - 1 || nums[m + 1] != target) {
                        max = m;
                        break;
                    }
                    else {
                        l = m + 1;
                    }
                }
            }
        }
        int ans[] = new int[2];
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
}
