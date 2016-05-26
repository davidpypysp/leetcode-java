package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 5/21/16.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = nums[0];
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++) {
            ans[i] += product;
            product *= nums[i];
        }
        product = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }
        return ans;
    }
}
