package com.shiping.leetcode.easy;

import java.util.Arrays;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int ans[] = nums;
		int a1[] = Arrays.copyOfRange(nums, 0, nums.length - k);
		int a2[] = Arrays.copyOfRange(nums, nums.length - k, nums.length);
		System.arraycopy(a2, 0, nums, 0, a2.length);
		System.arraycopy(a1, 0, nums, a2.length, a1.length);
	}
	
	public int[] move(int[] nums) {
		int ans[] = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			ans[(i + 1) % nums.length] = nums[i]; 
		}
		return ans;
	}

}
