package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/4/16.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int d[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) d[i][j] = 1;
                else {
                    if(j - 1 >= 0) d[i][j] += d[i][j-1];
                    if(i - 1 >= 0) d[i][j] += d[i-1][j];
                }
            }
        }
        return d[m-1][n-1];
    }
}
