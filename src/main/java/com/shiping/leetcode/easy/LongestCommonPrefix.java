package com.shiping.leetcode.easy;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		if(strs.length == 1) return strs[0];
		int min = strs[0].length();
		for(int i = 0; i < strs.length; i++) {
			if(strs[i].length() < min) {
				min = strs[i].length();
			}
		}
		boolean flag = true;
		String ans = "";
		for(int i = 0; i < min; i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j <strs.length; j++) {
				if(strs[j].charAt(i) != c) {
					flag = false;
					break;
				}
			}
			if(!flag) break;
			ans += c + "";
			
		}
		return ans;
	}

}
