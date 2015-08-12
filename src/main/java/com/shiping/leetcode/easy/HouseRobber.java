package com.shiping.leetcode.easy;

public class HouseRobber {
	
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		int max[] = new int[nums.length];
		for(int i = nums.length - 1; i >= 0; i--) {
			if(i == nums.length - 1 ) max[i] = nums[i];
			else if(i == nums.length - 2 ) max[i] = Math.max(nums[i], nums[i + 1]);
			else {
				max[i] = Math.max(nums[i] + max[i+2], max[i+1]);
			}
		}
		return max[0];
	}

}
