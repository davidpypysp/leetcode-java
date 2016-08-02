package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shipingci on 7/31/16.
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        new RepeatedDNASequences().findRepeatedDnaSequences(s);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i+10);
            if(map.containsKey(sub) == false) {
                map.put(sub, false);
            } else {
                if(map.get(sub) == false) {
                    res.add(sub);
                    map.put(sub, true);
                }
            }
        }
        return res;

    }
}
