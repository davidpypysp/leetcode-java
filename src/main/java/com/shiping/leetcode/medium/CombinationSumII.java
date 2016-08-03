package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shipingci on 8/3/16.
 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combination(candidates, target, list, 0);
        return res;
    }

    public void combination(int[] candidates, int target, List<Integer> list, int index) {
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] < target) {
                list.add(candidates[i]);
                List<Integer> newlist = new ArrayList<Integer>(list);
                combination(candidates, target-candidates[i], newlist, i+1);
                list.remove(list.size()-1);
            } else if(candidates[i] == target) {
                list.add(candidates[i]);
                res.add(list);
                return;
            } else {
                break;
            }

        }
    }
}
