package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 5/28/16.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> pre = new ArrayList<Integer>();
        dfs(ans, pre, n, k);
        return ans;

    }
    public void dfs(List<List<Integer>> ans, List<Integer> pre, int n, int k) {
        int len = pre.size();
        if(len == k) {
            ans.add(pre);
            return;
        }
        int left = len == 0 ? 0 : pre.get(len-1);
        for(int i = left+1; i <= n - (k - len) + 1; i++) {
            List<Integer> cur = new ArrayList<Integer>(pre);
            cur.add(i);
            dfs(ans, cur, n, k);
        }
    }
}
