package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/14/16.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int d[] = new int[num+1];
        int down[] = new int[num+1];


        for(int i = 0; i <= num; i++) {
            dp(i, d, down);
        }
        return d;
    }

    public int dp(int num, int[] d, int[] down) {
        if(num == 0) return 0;
        if(d[num] != 0) return d[num];
        down[num] = down[num - 1];
        if(( num & (num - 1) ) == 0) {
            d[num] = 1;
            down[num] = num;
        }
        else {
            d[num] = d[down[num]] + d[num - down[num]];
        }
        return d[num];
    }
}
