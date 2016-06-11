package com.shiping.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidpy on 6/4/16.
 */
public class WordPattern {
    public static void main(String[] args) {
        new WordPattern().wordPattern("abba", "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(arr.length > pattern.length()) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(i >= arr.length) return false;
            String s = arr[i];
            if(map.containsKey(c) == false) {
                if(map2.containsKey(s) == false) {
                    map.put(c, s);
                    map2.put(s, c);
                }
                else {
                    return false;
                }
            }
            else if(map.get(c).equals(s) == false) {
                return false;
            }

        }
        return true;
    }
}
