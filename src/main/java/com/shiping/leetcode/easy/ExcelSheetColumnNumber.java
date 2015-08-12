package com.shiping.leetcode.easy;

public class ExcelSheetColumnNumber {
	
	public int titleToNumber(String s) {
		int ans = 0, k = 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			ans += (s.charAt(i) - 'A' + 1) * k;
			k *= 26;
		}
		return ans;
	}

}
