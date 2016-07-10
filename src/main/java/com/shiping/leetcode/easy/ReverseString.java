package com.shiping.leetcode.easy;

/**
 * Created by shipingci on 7/10/16.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return new String(arr);
    }
}
