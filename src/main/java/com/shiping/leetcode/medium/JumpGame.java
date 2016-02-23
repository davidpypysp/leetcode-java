package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 16/2/22.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int index = 0;
        int rightmost = 0;
        if(len <= 1) return true;
        do {
            rightmost = Math.max(rightmost, index + nums[index]);
            if(rightmost >= len - 1) return true;
            index++;

        } while (index <= rightmost);
        return false;
    }
}
