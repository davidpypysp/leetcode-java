package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/3/16.
 */
public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<Integer>();
        combination(0, k, n, list);
        return res;
    }

    void combination(int prev, int k, int n, List<Integer> list) {
        if(k == 0) {
            if(n == 0) {
                res.add(list);
            }
            return;
        }
        for(int i = prev+1; i <= 9; i++) {
            if(i > n) break;
            list.add(i);
            List<Integer> newlist = new ArrayList<Integer>(list);
            combination(i, k-1, n-i, newlist);
            list.remove(list.size()-1);
        }
    }
}
