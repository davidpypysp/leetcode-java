package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/4/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        int d[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                d[i][j] = grid[i][j];
                boolean left = false;
                if(j - 1 >= 0) {
                    d[i][j] = grid[i][j] + d[i][j-1];
                    left = true;
                }
                if(i - 1 >= 0) {
                    if(left) d[i][j] = Math.min(d[i][j], grid[i][j] + d[i-1][j]);
                    else d[i][j] = grid[i][j] + d[i-1][j];

                }
            }
        }
        return d[n-1][m-1];
    }
}
