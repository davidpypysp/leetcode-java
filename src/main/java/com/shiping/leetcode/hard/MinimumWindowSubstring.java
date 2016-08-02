package com.shiping.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shipingci on 7/31/16.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        Map<Character, Boolean> checkMap = new HashMap<Character, Boolean>();
        int checkSize = 0;
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!tMap.containsKey(c)) {
                tMap.put(c, 1);
                checkMap.put(c, false);
            } else {
                tMap.put(c, tMap.get(c)+1);
            }
        }
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String res = "";
        int count = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            if(tMap.containsKey(c)) {
                if(!map.containsKey(c)) {
                    map.put(c, 1);
                    count++;
                } else {
                    map.put(c, map.get(c) + 1);
                    count++;
                }

                while (!map.containsKey(s.charAt(l)) || map.get(s.charAt(l)) > tMap.get(s.charAt(l))) {
                    if(map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                        count--;
                    }
                    l++;
                }

                if(checkMap.get(c) == false && map.get(c) >= tMap.get(c)) {
                    checkMap.put(c, true);
                    checkSize++;
                }

                if(checkSize == checkMap.size()) {
                    if(res == "" || (r-l+1) < res.length()) {
                        res = s.substring(l, r+1);
                    }
                }
            }
            r++;
        }
        return res;
    }
}
