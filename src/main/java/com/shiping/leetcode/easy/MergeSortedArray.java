package com.shiping.leetcode.easy;

public class MergeSortedArray {
	public static void main(String[] args) {

	}
	

	
	public void merge(int[] nums1, int m, int [] nums2, int n) {
		int[] temp = new int[m + n];
		int pos1 = 0, pos2 = 0, pos3 = 0;
		while(pos1 < m || pos2 < n) {
			if(pos1 < m && pos2 < n) {
				if(nums1[pos1] < nums2[pos2]) temp[pos3++] = nums1[pos1++];
				else temp[pos3++] = nums2[pos2++];
			}
			else if(pos1 < m && pos2 >= n) {
				temp[pos3++] = nums1[pos1++];
			}
			else if(pos1 >= m && pos2 < n) {
				temp[pos3++] = nums2[pos2++];
			}
		}
		for(int i = 0; i < pos3; i++) {
			nums1[i] = temp[i];
		}
	}

}
