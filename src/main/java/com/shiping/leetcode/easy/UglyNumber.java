package com.shiping.leetcode.easy;

/**
 * Created by davidpy on 5/22/16.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        int ugly[] = {2, 3, 5};
        for(int i = 0; i < 3; i++) {
            while(num % ugly[i] == 0)
                num /= ugly[i];
            if(num == 1) return true;
        }
        return false;
    }
}
