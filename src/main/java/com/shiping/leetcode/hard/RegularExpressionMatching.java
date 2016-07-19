package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 7/19/16.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int sn = sArray.length;
        int pn = pArray.length;

        boolean d[][] = new boolean[sn + 1][pn + 1];

        d[0][0] = true;
        for (int i = 1; i <= pn; i++) {
            if (pArray[i-1] == '*') d[0][i] = d[0][i-2];
        }

        for (int i = 1; i <= sn; i++) {
            for (int j = 1; j <= pn; j++) {
                if (pArray[j-1] == '*') {
                    d[i][j] = d[i][j-2] || d[i][j-1] || ((pArray[j-2] == '.' || pArray[j-2] == sArray[i-1]) && d[i-1][j]);
                } else if (pArray[j-1] == '.') {
                    d[i][j] = d[i - 1][j - 1];
                } else if (pArray[j-1] == sArray[i-1]) {
                    d[i][j] = d[i - 1][j - 1];
                }
            }
        }
        return d[sn][pn];
    }

}
