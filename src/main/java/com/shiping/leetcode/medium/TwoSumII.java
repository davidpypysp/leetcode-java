package com.shiping.leetcode.medium;

import java.util.HashMap;

/**
 * Created by shipingci on 9/7/16.
 */




public class TwoSumII {

    public static void main(String[] args) {
        int numbers[] = {5, 25, 75};
        int target = 100;

        new TwoSumII().twoSum(numbers, target);
    }


    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = numbers.length;
        for(int i = 0; i < n; i++) {
            map.put(numbers[i], i+1);
        }
        for(int i = 0; i < n; i++) {
            if(numbers[i] > target) break;
            int second = target - numbers[i];
            if(map.containsKey(second)) {
                int res[] = new int[2];
                res[0] = i+1;
                res[1] = map.get(second);
                return res;
            }
        }
        return null;

    }
}
