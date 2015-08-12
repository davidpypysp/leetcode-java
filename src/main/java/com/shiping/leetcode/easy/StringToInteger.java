package com.shiping.leetcode.easy;

public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}
	
	public static int myAtoi(String str) {
		if(str.length() == 0) return 0;
		boolean negative = false;
		if(str.charAt(0) == ' ') {
			while(str.charAt(0) == ' ') str = str.substring(1);
		}
		if(str.charAt(0) == '-') {
			if(str.charAt(1) == '+') return 0;
			str = str.substring(1);
			negative = true;
		}
		else if(str.charAt(0) == '+') {
			if(str.charAt(1) == '-') return 0;
			str = str.substring(1);
		}
		int n = str.length();
		//int num = 0, k = 1;
		//Long num = new Long(0), k = new Long(1);
		long num = 0, k = 1;
		for(int i = n - 1; i >= 0; i--) {
			if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				str = str.substring(0, i);
				n = i;
			}
		}
		for(int i = n - 1; i >= 0; i--) {
			num += k * (str.charAt(i) - '0');
			if(negative && num > 2147483647) return -2147483648;
			if(!negative && num > 2147483647) return 2147483647;
			k *= 10;
		}
		//if(num == -2147483648 && !negative) return 2147483647;
		//if(num == 2147483647 && negative) return -2147483648;
		if(negative) num = -num;
		return (int)num;
	}

}
