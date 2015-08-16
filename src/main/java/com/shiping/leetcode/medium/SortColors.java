package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/12.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) red++;
            else if(nums[i] == 1) white++;
            if(nums[i] == 2) blue++;
        }
        int cnt = 0;
        for(int i = 0; i < red; i++)
            nums[cnt++] = 0;
        for(int i = 0; i < white; i++)
            nums[cnt++] = 1;
        for(int i = 0; i < blue; i++)
            nums[cnt++] = 2;
    }
}
