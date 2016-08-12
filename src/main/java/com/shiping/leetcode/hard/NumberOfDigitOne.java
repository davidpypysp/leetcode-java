package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/12/16.
 */
public class NumberOfDigitOne {
    public static void main(String[] args) {
        System.out.println((int)Math.pow(10, 4));
        System.out.println(Math.log10(90543));
    }

    int d[] = new int[20];
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        if(n < 10) return 1;
        int k = (int)Math.log10(n);
        int bottom = (int)Math.pow(10, k);
        int firstDigit = n/bottom;
        if(firstDigit == 1) {
            return getD(k-1) + (n - bottom + 1) + countDigitOne(n % bottom);
        }
        return bottom + firstDigit * getD(k-1) + countDigitOne(n % bottom);
    }


    public int getD(int k) {
        if(d[k] != 0) return d[k];
        if(k == 0) {
            d[0] = 1;
            return d[0];
        }
        d[k] = (int)Math.pow(10, k) + 10 * getD(k-1);
        return d[k];
    }
}
