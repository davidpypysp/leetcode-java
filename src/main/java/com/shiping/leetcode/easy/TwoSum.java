package com.shiping.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidpy on 5/21/16.
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) == false) map.put(nums[i], i);
            else {
                if(target == nums[i] + nums[i]) {
                    int ans[] = new int[2];
                    ans[0] = map.get(nums[i]);
                    ans[1] = i;
                    return ans;
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            int nums1 = nums[i];
            int nums2 = target - nums1;
            if(map.containsKey(nums2) && map.get(nums1) != map.get(nums2)) {
                int ans[] = new int[2];
                ans[0] = map.get(nums1);
                ans[1] = map.get(nums2);
                return ans;
            }
        }
        return null;
    }
}
