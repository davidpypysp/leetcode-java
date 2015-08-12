package com.shiping.leetcode.easy;

public class ExcelSheetColumnTitle {
	
	public String converToTitle(int n) {
		String ans = "";
		while(n != 0) {
			ans = (char)('A' + ((n-1) % 26)) + "" + ans;
			n = (n - 1) / 26;
		}
		return ans;
	}

}
