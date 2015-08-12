package com.shiping.leetcode.easy;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(countPrimes(10000));
	}
	
	public static int countPrimes(int n) {
		if(n <= 2) return 0;
		boolean com[] = new boolean[(n + 1)];
		int ans = 1;
		for(int i = 3; i < n; i += 2) {
			if(!com[i]) {
				ans++;
				for(int j = i; j < n; j += i) com[j] = true;
			}
			
		}
		return ans;
	}

}
