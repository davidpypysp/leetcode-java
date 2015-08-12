package com.shiping.leetcode.easy;

import java.util.Scanner;

public class HappyNumber {
	
	public static void main(String[] args) {
		
	}
	
	public boolean isHappy(int n) {
		boolean vis[] = new boolean[1000];
		while(true) {
			if(n < 1000) vis[n] = true;
			int next = 0;
			while(n != 0) {
				next += (n % 10) * (n % 10);
				n /= 10;
			}
			n = next;
			if(n == 1) {
				return true;
			}
			else if(vis[n] == true) {
				return false;
			}
		}
	}
	
	

}
