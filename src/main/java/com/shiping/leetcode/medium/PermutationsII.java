package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davidpy on 5/20/16.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while(true) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++) list.add(nums[i]);
            ans.add(list);
            if(nextPermutation(nums) == true) break;
        }
        return ans;

    }

    public boolean nextPermutation(int[] nums) {
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(nums[i] < prev) {
                for(int j = n-1; j > i; j--) {
                    if(nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
                for(int left = i+1, right = n-1; left < right; left++, right--) { //reverse
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                return false;
            }
            prev = nums[i];
        }

        return true;
    }
}
