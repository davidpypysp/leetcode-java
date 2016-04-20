package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/17/16.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int d[] = new int[n];
        int max = 0;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            int v = prices[i] - prices[i-1];
            max = Math.max(v, v + d[i-1]);
            for(int j = 0;j < i - 2; j++) {
                max = Math.max(max, v + d[j]);
            }
            d[i] = max;
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }
}
