package com.shiping.leetcode.easy;

/**
 * Created by shipingci on 7/10/16.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length -1;
        while(l < r) {
            while(l < arr.length && !isVowel(arr[l])) l++;
            while(r >= 0 && !isVowel(arr[r])) r--;
            if(l < r) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
