package com.shiping.leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num[] = new int[10];
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}
		int c = majorityElement(num);
		System.out.println(c);
		
	}
	
	
    static public int majorityElement(int[] num) {
    	Arrays.sort(num);
    	return num[num.length / 2];
    }

}
