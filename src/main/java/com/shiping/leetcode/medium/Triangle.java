package com.shiping.leetcode.medium;

import java.util.List;

/**
 * Created by davidpy on 4/16/16.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int len = triangle.size();
        int d[] = new int[len];
        int prevd[] = new int[len];
        prevd[0] = triangle.get(0).get(0);
        for(int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if(j == 0) {
                    d[j] = num + prevd[j];

                }
                else if(j == i) {
                    d[j] = num + prevd[j-1];
                }
                else {
                    d[j] = Math.min(num + prevd[j-1], num + prevd[j]);
                }
            }
            for (int j = 0; j <= i; j++) {
                prevd[j] = d[j];
            }
        }

        int ans = d[0];
        for(int i = 0; i < len; i++) {
            ans = Math.min(ans, d[i]);
        }
        return ans;
    }

}
