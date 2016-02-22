package com.shiping.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by davidpy on 16/2/21.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashset.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}
