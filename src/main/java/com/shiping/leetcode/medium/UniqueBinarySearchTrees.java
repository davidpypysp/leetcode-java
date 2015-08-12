package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/6.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int v[] = new int[n+1];
        v[0] = v[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                v[i] += v[j] * v[i - 1 - j];
            }
        }
        return v[n];
    }
}
