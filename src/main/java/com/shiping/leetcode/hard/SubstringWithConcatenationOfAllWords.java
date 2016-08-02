package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shipingci on 8/2/16.
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        new SubstringWithConcatenationOfAllWords().findSubstring(s, words);

    }



    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int wordLen = 0, wordsLen = 0;

        for(String word : words) {
            wordLen = word.length();
            wordsLen += wordLen;
            if(map.containsKey(word) == false) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word)+1);
            }
        }

        boolean arr[] = new boolean[s.length()];
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i + wordLen <= s.length(); i++) {
            String sub = s.substring(i, i+ wordLen);
            if(map.containsKey(sub)) {
                arr[i] = true;
                if(i - wordLen < 0 || arr[i-wordLen] == false) {
                    list.add(i);
                }
            }
        }


        Map<String, Integer> check = new HashMap<String, Integer>();
        for(int i = 0; i < list.size(); i++) {
            int l = list.get(i), r = l;
            check.clear();
            int count = 0;
            while(r < arr.length && arr[r] == true) {
                String sub = s.substring(r, r+wordLen);
                if(check.containsKey(sub) == false) {
                    check.put(sub, 1);
                    count++;
                } else {
                    check.put(sub, check.get(sub)+1);
                    count++;
                }

                while(check.get(sub) > map.get(sub)) {
                    String ls = s.substring(l, l+wordLen);
                    check.put(ls, check.get(ls)-1);
                    count--;
                    l += wordLen;
                }

                if(count == words.length) {
                    res.add(l);
                }

                r += wordLen;
            }
        }
        return res;

    }
}
