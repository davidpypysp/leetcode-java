package com.shiping.leetcode.easy;

/**
 * Created by shipin on 2016/1/24.
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        while(num >= 10) {
            int val = 0;
            while (num != 0) {
                val += num % 10;
                num /= 10;
            }
            num = val;
        }
        return num;
    }
}
