package com.shiping.leetcode.easy;

public class NumberOf1Bits {
	
	public static void main(String[] args) {
		
	}
	
	
	/* Time Limited Exceed!
	public int hammingWeight(int n) {
		int ans = 0;
		while(n != 0) {
			if((n&1) == 1) ans++; 
			n >>= 1;
		}
		return ans;
	}
	*/
	
	public int hammingWeight(int n) {
		int ans = 0;
		while(n != 0) {
			n = n & (n-1);
			ans++;
		}
		return ans;
	}

}
