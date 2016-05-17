package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 5/12/16.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long top = 0;
        int i = 0;
        int patch = 0;
        while(top < n) {
            if(i < nums.length && nums[i] <= top+1 ) {
                top += nums[i];
                i++;
            }
            else {
                patch++;
                top += top+1;
            }
        }
        return patch;
    }
}
