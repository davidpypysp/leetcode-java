package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shipin on 2015/8/28.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int pre = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            if(num == pre) {
                pre = num;
                continue;
            }
            if(num > 0) break;
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = num + nums[l] + nums[r];
                if(sum < 0) {
                    l++;
                }
                else if(sum > 0) {
                    r--;
                }
                else if(sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);

                    while(l+1 < nums.length && nums[l+1] == nums[l]) l++;
                    l++;
                    while(r-1 >= 0 && nums[r-1] == nums[r]) r--;
                    r--;
                }
            }
            pre = num;
        }
        return ans;
    }
}
