package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shipingci on 7/9/16.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length == 0) return ans;
        Arrays.sort(nums);
        int d[] = new int[nums.length];
        int pre[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
        }

        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            d[i] = 1;
            pre[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0 && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    pre[i] = j;
                }
            }
            if(d[i] > d[maxIndex]) {
                maxIndex = i;
            }
        }

        int index = maxIndex;
        while(index != -1) {
            ans.add(nums[index]);
            index = pre[index];
        }
        return ans;
    }
}
