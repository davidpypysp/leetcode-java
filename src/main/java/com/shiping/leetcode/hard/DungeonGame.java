package com.shiping.leetcode.hard;

/**
 * Created by davidpy on 5/22/16.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int dp[][] = new int[n][m];// dp[i][j]: minimum hp to enter (i, j)

        dp[n-1][m-1] = Math.max(-dungeon[n-1][m-1], 0) + 1;// r-bottom node
        for (int i = n - 2; i >= 0; i--) // last row
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - dungeon[i][m-1]);
        for (int j = m - 2; j >= 0; j--) // last column
            dp[n-1][j] = Math.max(1, dp[n-1][j+1] - dungeon[n-1][j]);

        for (int i = n - 2; i >= 0; i--) {// calculate dp table
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]);// r, down
                dp[i][j] = Math.max(1, dp[i][j] - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
