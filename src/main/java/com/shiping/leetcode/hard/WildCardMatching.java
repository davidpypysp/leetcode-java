package com.shiping.leetcode.hard;

/**
 * Created by davidpy on 5/12/16.
 */
public class WildCardMatching {
    //s: *bc*dddd
    //p: ab*d



    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(n == 0 && m == 0) return true;
        boolean d[][] = new boolean[n+1][m+1];
        d[0][0] = true;
        for(int i = 1; i <= n; i++) { //d[i][0]
            if(s.charAt(i-1) == '*') d[i][0] = d[i-1][0];
        }
        for(int j = 1; j <= m; j++) {
            if(p.charAt(j-1) == '*') d[0][j] = d[0][j-1];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                char si = s.charAt(i-1);
                char pj = p.charAt(j-1);
                if(pj == '*' || si == '*') {
                    if(d[i][j-1] == true) d[i][j] = true;
                    if(d[i-1][j] == true) d[i][j] = true;
                    if(d[i-1][j-1] == true) d[i][j] = true;
                }
                else if(si == pj || si == '?' || pj == '?') {
                    if(d[i-1][j-1] == true) d[i][j] = true;
                }
            }
        }
        return d[n][m];
    }
}
