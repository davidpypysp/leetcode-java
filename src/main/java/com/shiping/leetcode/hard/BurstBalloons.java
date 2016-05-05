package com.shiping.leetcode.hard;

/**
 * Created by davidpy on 5/4/16.
 */
public class BurstBalloons {
    public static void main(String[] args) {
        int nums[] = {3,1,5,8};
        new BurstBalloons().maxCoins(nums);
    }

    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i = 1; i <= n; i++) {
            arr[i] = nums[i-1];
        }
        int dp[][] = new int[n+2][n+2];
        for(int len = 1; len <= n; len++) {
            for(int left = 1; left <=  n - (len - 1); left++) {
                int right = left + len - 1;
                for(int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right], arr[left-1] * arr[k] * arr[right+1] + dp[left][k-1] + dp[k+1][right]);
                }
            }
        }
        return dp[1][n];
    }
}
