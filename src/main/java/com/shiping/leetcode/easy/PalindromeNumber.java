package com.shiping.leetcode.easy;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
	
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
		if(x < 10) return true;
		int k = (int)Math.log10(x);
		for(int i = 0; i < (k+1) / 2; i++) {
			if(((int)(x / Math.pow(10, i)) % 10)  !=  ((int)(x / Math.pow(10, k - i)) % 10)) return false;
		}
		return true;
	}
	

}
