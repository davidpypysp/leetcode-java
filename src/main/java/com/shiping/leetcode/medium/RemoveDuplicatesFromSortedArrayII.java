package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipin on 2015/8/16.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int pos = 0, newpos = 0;
        int cnt = 0, val = nums[0];
        while(pos < nums.length) {
            if(val == nums[pos]) {
                cnt++;
            }
            else {
                val = nums[pos];
                cnt = 1;
            }
            if(cnt < 3) {
                nums[newpos++] = nums[pos];
            }
            pos++;
        }
        return newpos;
    }
}
