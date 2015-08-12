package com.shiping.leetcode.easy;

public class CompareVersionNumbers {
	public static void main(String[] args) {
		System.out.println(compareVersion("1.0", "11"));
	}
	
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int pos = 0;
		while(pos < v1.length || pos < v2.length) {
			if(pos < v1.length && pos < v2.length) {
				int num1 = Integer.parseInt(v1[pos]);
				int num2 = Integer.parseInt(v2[pos]);
				if(num1 < num2) return -1;
				else if(num1 > num2) return 1;
				else {
					pos++;
				}
			}
			if(pos >= v1.length && pos < v2.length) {
				int num2 = Integer.parseInt(v2[pos]);
				if(num2 > 0) return -1;
				else if(num2 == 0) return 0;
			}
			if(pos < v1.length && pos >= v2.length){
				int num1 = Integer.parseInt(v1[pos]);
				if(num1 > 0) return 1;
				else if(num1 == 0) return 0;
			}
		}
		return 0;
	}

}
