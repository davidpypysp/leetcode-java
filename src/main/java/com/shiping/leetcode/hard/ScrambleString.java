package com.shiping.leetcode.hard;

import java.util.Arrays;

/**
 * Created by davidpy on 5/4/16.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean d[][][] = new boolean[n][n][n+1];
        for(int k = 1; k <= n; k++) {
            for(int i = 0; i <= n - k; i++ ) {
                for(int j = 0; j <= n - k; j++) {
                    if(k == 1) {
                        d[i][j][k] = ( s1.charAt(i) == s2.charAt(j) );
                    }
                    else {
                        for(int q = 1; q < k && !d[i][j][k]; q++) {
                            d[i][j][k] = (d[i][j][q] && d[i+q][j+q][k-q]) || (d[i][j+k-q][q] && d[i+q][j][k-q]);
                        }
                    }
                }
            }
        }
        return d[0][0][n];
    }
}
