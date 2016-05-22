package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by davidpy on 5/21/16.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<Integer>();
            int val = i;
            for(int j = n-1; j >= 0; j--) {
                if(val % 2 == 1) {
                    list.add(nums[j]);
                }
                val >>= 1;
            }
            Collections.reverse(list);
            ans.add(list);
        }
        return ans;
    }
}
