package com.shiping.leetcode.easy;

/**
 * Created by shipin on 2016/1/24.
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(243));
    }

    public boolean isPowerOfThree(int n) {
        double k = Math.log10( (double) n ) / Math.log10(3.0);
        return k == (int) k;

    }
}
