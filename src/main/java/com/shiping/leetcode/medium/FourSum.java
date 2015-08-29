package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by shipin on 2015/8/28.
 */
public class FourSum {
    public static void main(String[] args) {
        //Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<List<Integer>> set = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(3);
        l1.add(4);
        l1.add(5);
        set.add(l1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(6);
        l2.add(7);
        l2.add(8);
        set.add(l2);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(3);
        l3.add(4);
        l3.add(5);
        set.add(l3);

        System.out.println(set);
    }



    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int l = j+1, r = nums.length - 1;
                while(l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        set.add(list);
                        l++;
                        r--;
                    }
                    else if(sum < target) {
                        l++;
                    }
                    else if(sum > target) {
                        r--;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Iterator<List<Integer>> it = set.iterator();
        while(it.hasNext()) {
            ans.add(it.next());
        }
        return ans;
    }
}
