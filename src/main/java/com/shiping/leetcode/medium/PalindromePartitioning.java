package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/5/16.
 */
public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<List<String>>();
    boolean p[][];
    String str;

    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();
        str = s;
        p = new boolean[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            p[i][i] = true;
        }
        List<String> list = new ArrayList<String>();
        dfs(arr, 0, list);
        return res;

    }

    void dfs(char[] arr, int index, List<String> list) {
        if(index == arr.length) {
            res.add(new ArrayList<String>(list));
            return;
        }
        int l = index;
        for(int r = index; r < arr.length; r++) {
            if(arr[l] == arr[r] && (l+1 > r-1 || p[l+1][r-1] == true) ) {
                p[l][r] = true;
                list.add(str.substring(l, r+1));
                dfs(arr, r+1, list);
                list.remove(list.size()-1);
            }
        }

    }

}
