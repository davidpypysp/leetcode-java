package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/6/16.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder("");
        boolean first = true;
        if(s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int i = arr.length-1;
        while(i >= 0) {
            char c = arr[i];
            if(c == ' ') {
                i--;
                continue;
            } else {
                int r = i;
                while(i-1 >= 0 && arr[i-1] != ' ') {
                    i--;
                }
                if(!first) {
                    res.append(" ");
                }
                res.append(s.substring(i, r+1));
                first = false;
                i--;
            }
        }
        return res.toString();
    }
}
