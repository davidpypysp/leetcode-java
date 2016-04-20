package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/17/16.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int value = new CoinChange().coinChange(coins, 6249);
        System.out.println(value);
    }

    public int coinChange(int[] coins, int amount) {
        int d[] = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            int min = i + 1;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    int value = d[i - coins[j]];
                    if(value != -1) {
                        min = Math.min(min, value);
                    }
                }
            }
            if(min == i + 1) {
                d[i] = -1;
            }
            else {
                d[i] = min + 1;
            }
        }
        return d[amount];


    }


}
