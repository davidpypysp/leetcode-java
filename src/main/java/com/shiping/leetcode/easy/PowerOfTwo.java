package com.shiping.leetcode.easy;

/**
 * Created by shipin on 2015/8/4.
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerofTwo(10));
    }

    public boolean isPowerofTwo(int n) {
        if(n <= 0) return false;
        int one = 0;
        while(n != 0) {
            if((n & 1) == 1) one++;
            n >>= 1;
        }
        if(one == 1) return true;
        return false;
    }
}
