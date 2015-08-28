package com.shiping.leetcode.medium;

import java.util.Arrays;

/**
 * Created by shipin on 2015/8/28.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 9, -3};
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = num + nums[l] + nums[r];

                if(ans == Integer.MIN_VALUE) {
                    ans = sum;
                }
                else {
                    ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum : ans;
                }

                if(sum > target) {
                    r--;
                }
                else if(sum < target) {
                    l++;
                }
                else if(sum == target) {
                    break;
                }
            }

        }
        return ans;
    }
}
