package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/23.
 */
public class PowXN {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        else if(n < 0) return 1 / pow(x, -n);
        else return pow(x, n);
    }

    public double pow(double x, int n) {
        if(n == 1) return x;
        if(n % 2 == 1) return x * myPow(x, n - 1);
        else {
            double t = myPow(x, n / 2);
            return t * t;
        }
    }
}
