package com.shiping.leetcode.easy;

import java.util.Scanner;

public class RemoveElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, next = 0;
		int[] A = new int[20];
		while((n = scanner.nextInt()) != -1) {
			A[next++] = n;
		}
		int elem = scanner.nextInt();
		
		int ans = removeElement(A, elem);
		System.out.println(ans);
		
	}
	
	public static int removeElement(int A[], int elem) {
		int ans = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] != elem ) {
				A[ans] = A[i];
				ans++;
			}
		}
		return ans;
	}

}
