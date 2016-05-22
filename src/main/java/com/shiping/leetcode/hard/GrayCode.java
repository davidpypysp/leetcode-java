package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 5/19/16.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        int total = 1 << n;
        boolean vis[] = new boolean[total];
        int code[] = new int[n];
        int cnt = 0;
        while(cnt < total) {
            int val = toNum(code);
            vis[val] = true;
            ans.add(val);
            for(int i = n-1; i >= 0; i--) {
                code[i] = 1 - code[i];
                val = toNum(code);
                if(!vis[val]) {
                    break;
                }
                else {
                    code[i] = 1 - code[i];
                }

            }
            cnt++;
        }
        return ans;
    }

    int toNum(int nums[]) {
        int n = nums.length;
        int val = 0;
        for(int i = n-1, b = 1; i >=0; i--) {
            val += b * nums[i];
            b = b << 1;
        }
        return val;
    }
}
