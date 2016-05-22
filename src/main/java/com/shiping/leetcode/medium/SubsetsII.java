package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by davidpy on 5/18/16.
 */
public class SubsetsII {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        p(nums, list, 0, 0);
        return ans;
    }

    public void p(int nums[], List<Integer> list, int cur, int idx) {
        ans.add(list);
        int prev = Integer.MIN_VALUE;
        if(cur == nums.length) return;
        for(int i = idx; i < nums.length; i++) {
            if(nums[i] == prev) continue;
            List<Integer> newlist = new ArrayList<Integer>(list);
            newlist.add(nums[i]);
            p(nums, newlist, cur+1, i+1);
            prev = nums[i];
        }

    }

}
