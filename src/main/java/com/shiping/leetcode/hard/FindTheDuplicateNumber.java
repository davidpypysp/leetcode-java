package com.shiping.leetcode.hard;

import java.util.Arrays;

/**
 * Created by davidpy on 5/17/16.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int l = 0, r = nums.length;
        while(l < r) {
            int m = l + (r - l) / 2;
            if((m-1 >= 0 && nums[m-1] == nums[m]) || (m+1 < nums.length && nums[m] == nums[m+1])) {
                return nums[m];
            }
            if(nums[m] > m) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return 0;
    }
}
