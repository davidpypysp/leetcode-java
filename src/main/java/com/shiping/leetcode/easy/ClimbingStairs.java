package com.shiping.leetcode.easy;

public class ClimbingStairs {
	
	public int climbStairs(int n) {
		if(n == 0) return 0;
		int max[] = new int[n];
		for(int i = n - 1; i >= 0; i--) {
			if(i == n - 1) max[i] = 1;
			else if(i == n - 2) max[i] = 2;
			else {
				max[i] = max[i+1] + max[i+2];
			}
		}
		return max[0];
	}

}
