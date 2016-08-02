package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by shipingci on 7/31/16.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String s = "cba";
        String ns = new GroupAnagrams().sort(s);
        System.out.println(ns);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            String s = sort(strs[i]);
            if(map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(strs[i]);

            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                res.add(list);
                map.put(s, list);
            }
        }
        return res;
    }

    public String sort(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
