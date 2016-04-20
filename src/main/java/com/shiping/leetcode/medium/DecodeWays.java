package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/19/16.
 */
public class DecodeWays {

    public static void main(String[] args) {
        String s = "0";
        DecodeWays c = new DecodeWays();
        int ans = c.numDecodings(s);
        System.out.println(ans);
    }

    static int[] d;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        d = new int[s.length() + 1];
        d[s.length()] = 1;
        //1134573456 11111111 999 330 cc0 120 1,20 1120 1,1,20 11,20
        //return dp(s, 0);
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                d[i] = 0;
                continue;
            }
            if( i < s.length()-1 && Integer.parseInt(s.substring(i, i+2)) <= 26 ) {
                d[i] += d[i + 2];
            }
            d[i] += d[i+1];
        }
        return d[0];
    }

    public int dp(String s, int k) {
        if(k == s.length()) return 1;
        if(s.charAt(k) == '0') {
            d[k] = 0;
            return 0;
        }
        if(d[k] != 0) return d[k];
        int ans = 0;
        if( k < s.length()-1 && Integer.parseInt(s.substring(k, k+2)) <= 26 ) {
            ans += dp(s, k + 2);
        }
        ans += dp(s, k + 1);
        d[k] = ans;
        return d[k];
    }
}
