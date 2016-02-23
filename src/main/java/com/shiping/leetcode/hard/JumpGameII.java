package com.shiping.leetcode.hard;

/**
 * Created by davidpy on 16/2/22.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len <= 1) return 0;
        int rngs[] = new int[len];
        for(int i = 0; i < len; i++)
            rngs[i] = i + nums[i];
        int maxrng = -1;
        int step = 1;
        int index = 0;
        int rng = rngs[0];
        while(index < len -1) {
            if(rng >= len - 1) return step;
            maxrng = Math.max(maxrng, rngs[index]);
            index++;
            if(index > rng) {
                rng = maxrng;
                step++;
            }
        }
        return step;
    }
}
