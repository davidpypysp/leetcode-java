package com.shiping.leetcode.medium;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by davidpy on 16/2/22.
 */
public class BestTimeToBuyAndSellStockII{
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int ans = 0;

        List<Integer> maximum = new ArrayList<Integer>();
        List<Integer> minimum = new ArrayList<Integer>();



        for(int i = 0; i < prices.length; i++) {
            if( (i == 0 && prices[i] < prices[i + 1]) || (i != 0 && i != prices.length - 1 && prices[i] <= prices[i-1] && prices[i] < prices[i+1]))
                minimum.add(prices[i]);
            else if((i == prices.length - 1 && prices[i] > prices[i-1]) || (i != 0 && i != prices.length - 1 && prices[i] > prices[i-1] && prices[i] >= prices[i+1]))
                maximum.add(prices[i]);

        }

        Iterator<Integer> max = maximum.iterator();
        Iterator<Integer> min = minimum.iterator();

        while(max.hasNext() == true) {
            ans += max.next() - min.next();
        }

        return ans;

    }
}
