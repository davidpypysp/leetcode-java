package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 7/16/16.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num : nums) {
            int ta=(~a&b&num) | (a&~b&~num);
            b=(~a&~b&num) | (~a&b&~num);
            a = ta;
        }
        return a | b;
    }
}
