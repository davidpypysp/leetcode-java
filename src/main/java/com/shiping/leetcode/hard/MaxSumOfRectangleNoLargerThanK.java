package com.shiping.leetcode.hard;

import java.util.TreeSet;

/**
 * Created by shipingci on 7/16/16.
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int l = 0; l < m; l++) {
            int d[] = new int[n];
            for(int r = l; r < m; r++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int cum = 0;
                for(int i = 0; i < n; i++) {
                    d[i] += matrix[i][r];
                    cum += d[i];
                    if(cum <= k) ans = Math.max(ans, cum);
                    Integer pre = set.ceiling(cum - k);
                    if(pre != null) ans = Math.max(ans, cum - pre);
                    set.add(cum);
                }
            }
        }
        return ans;
    }
}
