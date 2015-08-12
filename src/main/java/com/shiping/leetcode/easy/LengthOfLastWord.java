package com.shiping.leetcode.easy;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		int len = 0;
		boolean flag = false;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == ' ') {
				if(flag) break;
			}
			else {
				if(!flag) flag = true;
				len++;
			}
		}
		return len;
	}

}
