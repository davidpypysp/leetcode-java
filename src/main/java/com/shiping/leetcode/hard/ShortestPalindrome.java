package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/7/16.
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        new ShortestPalindrome().shortestPalindrome("aabba");
    }

    public String shortestPalindrome(String s) {
        if(s.length() == 0) return s;
        StringBuilder s2 = new StringBuilder(s);
        char arr[] = s.toCharArray();
        s2.append("#");
        s2.append(new StringBuilder(s).reverse());
        int[] next = getNext(s2.toString().toCharArray());
        int preLen = next[s2.length()];
        StringBuilder pre = new StringBuilder(s.substring(preLen));
        return pre.reverse().toString() + s;

    }

    int[] getNext(char[] arr) {
        int len = arr.length;
        int[] next = new int[len+1];
        next[0] = -1;
        int k = -1;
        int i = 0;
        while(i < len) {
            if(k == -1 || arr[i] == arr[k]) next[++i] = ++k;
            else k = next[k];
        }
        return next;

    }

}
