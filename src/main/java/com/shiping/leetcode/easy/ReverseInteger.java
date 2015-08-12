package com.shiping.leetcode.easy;

public class ReverseInteger {
	
	public int reverse(int x) {
		boolean negative = false;
		if(x < 0) {
			negative = true;
			x = -x;
		}
		String s = ((Integer)x).toString();
		long y = 0, k = 1;
		for(int i = 0; i < s.length(); i++) {
			y += (s.charAt(i) - '0') * k;
			k *= 10;
		}
		if(y > 2147483647) y = 0;
		if(negative) y = -y;
		return (int)y;
		
	}

}
