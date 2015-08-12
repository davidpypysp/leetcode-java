package com.shiping.leetcode.easy;

public class FactorialTrailingZeroes {
	public static void main(String[] args) {

        System.out.println(trailingZeroes(4));
	}
	
	public static int trailingZeroes(int n) {
        int ans = 0;
		int k = 5;
		while(n > 0) {
			ans += n / 5;
			n /= 5;
		}
		return ans;   
	}

}
