package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/5/16.
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        String res = "";
        String str = "#";
        for(int i = 0; i < s.length(); i++) {
            str += s.charAt(i) + "#";
        }

        int rl[] = new int[str.length()];
        int maxRight = 0;
        int pos = 0;
        int maxLen = 0;
        int center = 0;
        for(int i = 0; i < str.length(); i++) {
            if(i < maxRight) {
                rl[i] = Math.min(rl[2*pos - i], maxRight-i);
            } else {
                rl[i] = 1;
            }

            while(i-rl[i] >= 0 && i+rl[i] < str.length() && str.charAt(i-rl[i]) == str.charAt(i+rl[i])) {
                rl[i]++;
            }

            if(i+rl[i]-1 > maxRight) {
                maxRight = i+rl[i]-1;
                pos = i;
            }

            if(maxLen < rl[i]) {
                maxLen = rl[i];
                center = i;
            }
        }
        maxLen--;
        int l = (center - maxLen) / 2, r = (center + maxLen) / 2;
        res = s.substring(l, r);
        return res;

    }


}
