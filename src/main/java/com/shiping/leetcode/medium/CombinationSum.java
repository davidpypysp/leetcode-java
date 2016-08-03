package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shipingci on 8/3/16.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        new CombinationSum().combinationSum(candidates, target);
    }


    List<List<Integer>> res = new ArrayList<List<Integer>>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        combination(candidates, target, list, 0);
        return res;

    }

    public void combination(int[] candidates, int target, List<Integer> list, int index) {
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] < target) {
                list.add(candidates[i]);
                List<Integer> newlist = new ArrayList<Integer>(list);
                combination(candidates, target-candidates[i], newlist, i);
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
