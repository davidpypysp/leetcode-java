package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 7/9/16.
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int ans = 10;
        if(n == 1)
        return ans;
        int f = 9;
        for(int i = 2; i <= n; i++) {
            if(i == 11) break;
            f *= (11 - i);
            ans += f;
        }
        return ans;
    }
}
