package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by davidpy on 4/22/16.
 */
public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        new WordBreakII().wordBreak(s, wordDict);
    }

    List<String> ans = new ArrayList<String>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == "" || wordDict.size() == 0) return new ArrayList<String>();
        int n = s.length();
        int len = 0;
        for(String w : wordDict) {
            len = Math.max(len, w.length());
        }
        List<String>[] d = new List[n + 1];
        d[n] = new ArrayList<String>();
        d[n].add("");
        for(int i = n-1; i >= 0; i--) {
            d[i] = new ArrayList<String>();
            int l = Math.min(i + len, n);
            for(int j = i+1; j <= l; j++) {
                String w = s.substring(i, j);
                if(wordDict.contains(w) && d[i + w.length()].size() != 0) {
                    d[i].add(w);
                }
            }
        }



        dp(d, 0, "");
        return ans;
    }

    void dp(List<String> d[], int index, String pre) {
        if(index == d.length-1) {
            ans.add(pre);
            return;
        }
        for(String t : d[index]) {
            String pre2 = pre;
            if(pre2 == "") pre2 = pre2 + t;
            else pre2 = pre2 + " "  + t;
            dp(d, index + t.length(), pre2);
        }
    }


}
