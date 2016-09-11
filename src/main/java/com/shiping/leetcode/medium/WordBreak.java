package com.shiping.leetcode.medium;

import java.util.Set;

/**
 * Created by shipingci on 9/10/16.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return false;
        return helper(s, wordDict);
    }

    public boolean helper(String s, Set<String> wordDict) {
        int n = s.length();
        boolean d[] = new boolean[n+1];
        d[n] = true;
        int maxlen = 0;
        for(String word : wordDict) {
            if(maxlen < word.length()) maxlen = word.length();
        }
        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n && (j-i+1) <= maxlen; j++) {
                String ls = s.substring(i, j+1);
                if(wordDict.contains(ls) && d[j+1] == true) {
                    d[i] = true;
                    break;
                }
            }
        }
        return d[0];

    }
}
