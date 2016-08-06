package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/5/16.
 */
public class RestoreIPAddresses {
    List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() == 0) return res;
        dfs(s, 0, 0, "");
        return res;
    }

    void dfs(String s, int index, int k, String cur) {
        if(k == 4) {
            if(index == s.length()) {
                res.add(cur.substring(0, cur.length() -1));
            }
            return;
        }
        for(int i = index; i < index + 3; i++) {
            if(i >=  s.length()) break;
            String sub = s.substring(index, i+1);
            if(valid(sub)) {
                String next = cur + sub + ".";
                dfs(s, i+1, k+1, next);
            } else {
                break;
            }
        }
    }

    boolean valid(String s) {
        if(s.length() == 0) return false;
        if(s.charAt(0) == '0') {
            if(s.length() == 1) return true;
            else return false;
        }
        int num = Integer.parseInt(s);
        if(num >= 256) return false;
        return true;
    }
}
