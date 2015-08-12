package com.shiping.leetcode.easy;

import java.util.Scanner;

/*
 * Remove Duplicates
 * 
 */

public class RemoveDuplicates {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int A[] = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		int ans = removeDuplicates(A);
		for(int i = 0; i < ans; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("");
	}
	
	public static int removeDuplicates (int A[]) {
		if(A.length <= 1) return A.length;
		int next = 1;
		int t = A[0];
		for(int i = 1; i < A.length; i++) {
			if(t != A[i]) {
				t = A[i];
				A[next++] = A[i];
			}
		}
		
		return next;
	}
	
	

}
