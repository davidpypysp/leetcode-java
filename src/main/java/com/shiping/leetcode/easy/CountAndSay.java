package com.shiping.leetcode.easy;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
	
	public static String countAndSay(int n) {
		String s = "1";
		for(int i = 1; i < n; i++) {
			s = count(s);
		}
		return s;
	}
	
	public static String count(String s) {
		int val = s.charAt(0) - '0';
		int cnt = 0;
		String ans = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) - '0' == val) {
				cnt++;
			}
			else {
				ans += (cnt + "" + val + "");
				val = s.charAt(i) - '0';
				cnt = 1;
			}
			if(i + 1 == s.length()) {
				ans += (cnt + "" + val + "");
			}
			
		}
		return ans;
	}

}
