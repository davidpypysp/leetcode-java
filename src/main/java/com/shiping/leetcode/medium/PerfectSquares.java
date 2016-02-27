package com.shiping.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by davidpy on 16/2/26.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if(sqrt * sqrt == ((double) i)) dp[i] = 1;
            int min = i;
            for(int j = 1; j <= sqrt; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return  dp[n];
    }
}
