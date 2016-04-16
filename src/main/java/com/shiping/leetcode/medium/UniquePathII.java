package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/4/16.
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if(n == 0) return 0;
        int m = obstacleGrid[0].length;
        if(m == 0) return 0;
        int d[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if(i == 0 && j == 0 && obstacleGrid[i][j] != 1) d[i][j] = 1;
                else {
                    if(obstacleGrid[i][j] == 1) continue;
                    if(j - 1 >= 0 && obstacleGrid[i][j-1] != 1) d[i][j] += d[i][j-1];
                    if(i - 1 >= 0 && obstacleGrid[i-1][j] != 1) d[i][j] += d[i-1][j];
                }

            }
        }
        return d[n-1][m-1];
    }
}
