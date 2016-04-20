package com.shiping.leetcode.hard;

import com.shiping.leetcode.medium.BestTimeToBuyAndSellStock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 4/18/16.
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {3,5,3,4,1,4,5,0,7,8,5,6,9,4,1};
        int ans = new BestTimeToBuyAndSellStockIII().maxProfit(prices);
        System.out.println(ans);
    }


    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int d[] = new int[n]; //d[i] denote the max profit if sell at i
        int singled[] = new int[n];
        int count[] = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        int ans = 0;
        int singleValue = 0;
        int singleMin = prices[0], singleMax = prices[0];
        int singleIndex = 0;
        boolean updateSingleMin = false;
        int singleMinIndex = 0;
        int tobesingleMinIndex = 0;
        boolean hasMax = false;
        for(int i = 1; i < n; i++) {
            int v = prices[i] - prices[i-1];
            d[i] = v;
            singled[i] = v;
            count[i] = 1;
            if(v + d[i-1] > d[i]) {
                d[i] = v + d[i-1];
                count[i] = count[i-1];
                if(count[i] == 1)
                    singled[i] = d[i];
            }
            if(v + singleValue > d[i]) {
                d[i] = v + singleValue;
                if(singleIndex == i - 1) {
                    count[i] = 1;
                    singled[i] = d[i];
                }
                else if(singleIndex < i - 1) {
                    count[i] = 2;
                }

            }
            if(v + singled[i - 1] > singled[i]) {
                singled[i] = v + singled[i-1];
            }


            if(prices[i] > prices[i-1]) {
                if(!hasMax || prices[i] > singleMax) {
                    hasMax = true;
                    singleMax = prices[i];
                    singleValue = prices[i] - singleMin;
                    singleIndex = i;
                    if(updateSingleMin) {
                        singleMinIndex = tobesingleMinIndex;
                        updateSingleMin = false;
                    }
                }
            }
            else {
                if(prices[i] < singleMin) {
                    singleMin = prices[i];
                    tobesingleMinIndex = i;
                    updateSingleMin = true;
                    if(!hasMax) {
                        singleMax = prices[i];
                    }
                }
            }
            ans = Math.max(ans, d[i]);

        }

        for(int i = 0; i < singleMinIndex; i++) {
            ans = Math.max(ans, singled[i] + singleValue);
        }

        return ans;

    }

    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for(int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        return secondSell;

    }

}
