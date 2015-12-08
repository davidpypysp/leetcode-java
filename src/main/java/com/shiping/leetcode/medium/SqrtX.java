package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/24.
 */
public class SqrtX {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1 || x == 2 || x == 3) return 1;
        int left = 0, right = x / 2 + 1, mid = 0;
        if(right > 46341) right = 46341;
        while(left < right) {
            mid = (left + right) / 2;
            if(mid * mid == x) return mid;
            else if(mid * mid > x) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        if(mid * mid > x && (mid - 1) * (mid - 1) < x) return mid - 1;
        return mid;
    }
}
