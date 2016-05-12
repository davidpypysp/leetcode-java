package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 5/5/16.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int total = 0;
        int accumulation = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            accumulation += gas[i] - cost[i];
            if(accumulation < 0) {
                index = i + 1;
                accumulation = 0;
            }
        }
        if(total < 0) return -1;
        return index;
    }
}
