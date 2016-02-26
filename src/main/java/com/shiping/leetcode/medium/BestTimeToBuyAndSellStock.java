package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 16/2/24.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int min = prices[0];
        int ans = 0;
        int f[] = new int[len];
        f[0] = 0;
        for(int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i-1], prices[i] - min);
        }
        return f[len - 1];
    }
}
