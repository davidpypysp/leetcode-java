package com.shiping.leetcode.easy;

public class ReverseBits {
	
	public int ReverseBits(int n) {
		int m = 0;
		for(int i = 0; i < 32; i++) {
			m <<= 1;
			m = m | (n & 1);
			n >>= 1;
		}
		return m;
	}

}
