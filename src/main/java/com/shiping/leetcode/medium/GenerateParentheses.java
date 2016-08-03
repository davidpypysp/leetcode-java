package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by shipingci on 8/2/16.
 */
public class GenerateParentheses {
    List<List<String>> list = new ArrayList<List<String>>();

    public List<String> generateParenthesis(int n) {
        if(list.size() > n) return list.get(n);

        List<String> res = new ArrayList<String>();
        if(n == 0) {
            list.add(res);
            return res;
        }
        if(n == 1) {
            res.add("()");
            list.add(res);
            return res;
        }
        List<String> prev = generateParenthesis(n-1);
        for(String s : prev) {
            res.add("(" + s + ")");
        }
        Set<String> set = new HashSet<String>();
        for(int l = n-1, r = 1; l >= r; l--, r++) {
            List<String> left = generateParenthesis(l);
            List<String> right = generateParenthesis(r);
            for(String ls : left) {
                for(String rs : right) {
                    String s = ls + rs;
                    if(set.contains(s) == false) {
                        set.add(s);
                        res.add(s);
                    }
                    s = rs + ls;
                    if(set.contains(s) == false) {
                        set.add(s);
                        res.add(s);
                    }
                }
            }
        }
        return res;
    }
}
