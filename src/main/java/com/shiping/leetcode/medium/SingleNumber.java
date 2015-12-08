package com.shiping.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shipin on 2015/9/25.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = 0;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) == false) {
                map.put(nums[i], true);
                sum += nums[i];
            }
            else {
                sum -= nums[i];
            }
        }
        return sum;
    }
}
