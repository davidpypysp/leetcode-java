package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 6/4/16.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int d[] = new int[n+1];
        d[2] = 1;
        if(n == 2) return d[2];
        d[3] = 2;
        if(n == 3) return d[3];
        d[4] = 4;
        if(n == 4) return d[4];
        d[5] = 6;
        if(n == 5) return d[5];
        d[6] = 9;
        if(n == 6) return d[6];
        for(int i = 7; i <= n; i++) {
            d[i] = 3 * d[i - 3];
        }
        return d[n];
    }
}
