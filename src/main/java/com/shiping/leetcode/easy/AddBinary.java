package com.shiping.leetcode.easy;

public class AddBinary {
	
	public static void main(String[] args) {
		System.out.println(addBinary("111", "11"));
	}
	
	public static String addBinary(String a, String b) {
		boolean carry = false;
		String ans = "";
		int posA = a.length() - 1, posB = b.length() - 1;
		while(posA >= 0 || posB >= 0) {
			if(posA >= 0 && posB >= 0) {
				int num = add(a.charAt(posA), b.charAt(posB), carry);
				if(num == 0) {
					ans = "0" + ans;
					carry = false;
				}
				else if(num == 1) {
					ans = "1" + ans;
					carry = false;
				}
				else if(num == 2) {
					ans = "0" + ans;
					carry = true;
				}
				else if(num == 3) {
					ans = "1" + ans;
					carry = true;
				}
				posA--;
				posB--;
			}
			else if(posA >= 0 && posB < 0) {
				int num = add(a.charAt(posA), '0', carry);
				if(num == 0) {
					ans = "0" + ans;
					carry = false;
				}
				else if(num == 1) {
					ans = "1" + ans;
					carry = false;
				}
				else if(num == 2) {
					ans = "0" + ans;
					carry = true;
				}
				posA--;
			}
			else if(posA < 0 && posB >= 0) {
				int num = add(b.charAt(posB), '0', carry);
				if(num == 0) {
					ans = "0" + ans;
					carry = false;
				}
				else if(num == 1) {
					ans = "1" + ans;
					carry = false;
				}
				else if(num == 2) {
					ans = "0" + ans;
					carry = true;
				}
				posB--;
			}
		}
		if(carry) ans = "1" + ans;
		return ans;
	}
	
	public static int add(char a, char b, boolean carry) {
		int n1 = a - '0', n2 = b - '0';
		int ans = n1 + n2;
		if(carry) ans++;
		return ans;
	}

}
