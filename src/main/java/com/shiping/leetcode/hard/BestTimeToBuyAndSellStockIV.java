package com.shiping.leetcode.hard;

import java.util.Arrays;

/**
 * Created by davidpy on 4/18/16.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1 || k == 0) return 0;
        if(k > prices.length / 2) {
            int ans = 0;
            for(int i = 1; i < prices.length; i++) {
                ans += Math.max(prices[i] - prices[i-1], 0);
            }
            return ans;
        }

        int buy[] = new int[k];
        int sell[] = new int[k];

        Arrays.fill(buy, Integer.MIN_VALUE);

        for(int price : prices) {
            int prevSell = 0;
            for(int j = 0; j < k; j++) {
                buy[j] = Math.max(buy[j], prevSell - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
                prevSell = sell[j];
            }
        }
        return sell[k-1];

    }
}
