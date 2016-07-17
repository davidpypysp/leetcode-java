package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 7/17/16.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        char c[] = s.toCharArray();
        int n = c.length;
        int d[] = new int[n];
        boolean p[][] = new boolean[n][n];
        for(int r = 0; r < n; r++) {
            d[r] = r;
            for(int l = 0; l <= r; l++) {
                if(c[l] == c[r] && (l+1 > r-1 || p[l+1][r-1] == true)) {
                    p[l][r] = true;
                    if(l == 0) d[r] = 0;
                    else d[r] = Math.min(d[r], d[l-1] + 1);
                }
            }
        }
        return d[n-1];
    }
}
