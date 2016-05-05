package com.shiping.leetcode.hard;

/**
 * Created by davidpy on 5/4/16.
 */
public class EditDistance {
    // According to Levenshtein distance
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if(n1 == 0) {
            return n2;
        }
        if(n2 == 0) {
            return n1;
        }
        int lev[][] = new int[n1+1][n2+1];
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        for(int i = 1; i <= n1; i++) {
            lev[i][0] = i;
        }
        for(int i = 1; i <= n2; i++) {
            lev[0][i] = i;
        }

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                int opt1 = lev[i-1][j] + 1;
                int opt2 = lev[i][j-1] + 1;
                int opt3 = lev[i-1][j-1] + (s1[i-1] == s2[j-1] ? 0 : 1);
                lev[i][j] = Math.min(opt1, Math.min(opt2, opt3));

            }
        }
        return lev[n1][n2];
    }
}
