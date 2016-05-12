package com.shiping.leetcode.hard;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by davidpy on 5/5/16.
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 0) return 0;
        int num[] = new int[n];
        num[0] = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                num[i] = num[i-1] + 1;
            }
            else {
                num[i] = 1;
            }
        }
        int ans = num[n-1];
        for(int i = n-2; i >=0; i--) {
            if(ratings[i] > ratings[i+1] && num[i] < num[i+1] + 1) {
                num[i] = num[i+1] + 1;
            }
            ans += num[i];
        }
        return ans;
    }


}
