package com.shiping.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by davidpy on 5/18/16.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; i++) {
            int v = nums2[i];
            int l = 0, r = nums1.length;
            while(l < r) {
                int m = l + (r-l) / 2;
                if(nums1[m] == v) {
                    set.add(v);
                    break;
                }
                else if(v < nums1[m]) {
                    r = m;
                }
                else {
                    l = m+1;
                }
            }
        }
        int ans[] = new int[set.size()];
        int i = 0;
        for(Integer v : set) {
            ans[i++] = v;
        }
        return ans;
    }
}
