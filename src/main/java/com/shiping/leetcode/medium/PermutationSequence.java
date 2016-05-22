package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 5/20/16.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        new PermutationSequence().getPermutation(4, 15);
    }

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) nums.add(i);
        int fac[] = new int[n+1];
        fac[1] = 1;
        for(int i = 2; i <= n; i++) fac[i] = fac[i-1] * i;
        String ans = "";
        for(int i = n; i > 1; i--) {
            int index = (k-1) / fac[i-1];
            int num = nums.remove(index);
            ans += Integer.toString(num);
            k -= fac[i-1] * index;
        }
        ans += Integer.toString(nums.get(0));
        return ans;
    }
}
