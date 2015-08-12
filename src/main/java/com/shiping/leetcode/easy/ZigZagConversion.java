package com.shiping.leetcode.easy;

public class ZigZagConversion {
	
	public String convert(String s, int numRows) {
		if(numRows == 1) return s;
		char arr[][] = new char[numRows][s.length()];
		int pos = 0, x = 0, y = 0;
		boolean vertical = true;
		while(pos < s.length()) {
			arr[y][x] = s.charAt(pos++);
			if(vertical) {
				y++;
				if(y == numRows - 1) vertical = false;
			}
			else {
				x++;
				y--;
				if(y == 0) vertical = true;
			}
		}
		String ans = "";
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j <= x; j++) {
				if(arr[i][j] != 0) ans += arr[i][j] + ""; 
			}
		}
		return ans;
	}

}
