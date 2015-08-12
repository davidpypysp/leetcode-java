package com.shiping.leetcode.easy;

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		int pos = digits.length - 1;
		while(pos >= 0) {
			digits[pos]++;
			if(digits[pos] == 10) {
				digits[pos] = 0;
				pos--;
			}
			else break;
		}
		if(pos >= 0) return digits;
		int ndigits[] = new int[digits.length + 1];
		ndigits[0] = 1;
		for(int i = 1; i < ndigits.length; i++) ndigits[i] = digits[i-1];
		return ndigits;
	}

}
