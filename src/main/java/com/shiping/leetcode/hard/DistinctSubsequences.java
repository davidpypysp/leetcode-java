package com.shiping.leetcode.hard;

import java.util.Arrays;

/**
 * Created by davidpy on 4/20/16.
 */
public class DistinctSubsequences {
    static int d[][];
    public int numDistinct(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return 0;
        int n = s.length();
        int m = t.length();
        d = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                d[i][j] = -1;
        }
        return dp(s, t, 0, 0);

    }

    public int dp(String s, String t, int p, int q) {
        if(q == t.length()) return 1;
        else if(p == s.length()) return 0;
        if(d[p][q] != -1) return d[p][q];
        d[p][q] = 0;
        for(int i = p; i < s.length(); i++) {
            if(t.charAt(q) == s.charAt(i)) {
                d[p][q] +=dp(s, t, i+1, q+1);
            }
        }
        return d[p][q];
    }
}
