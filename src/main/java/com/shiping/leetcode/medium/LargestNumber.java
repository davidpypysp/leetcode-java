package com.shiping.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shipingci on 9/7/16.
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2};
    }


    class StringComparator implements Comparator<String>{

        @Override
        public int compare(String s1, String s2) {
            int n1 = s1.length(), n2 = s2.length();
            if(n2 < n1) return -compare(s2, s1); // keep s1's length < s2's length
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();
            int i = 0;
            while(i < n1) {
                if(arr1[i] == arr2[i]) i++;
                else return arr2[i] - arr1[i];
            }
            if(n1 == n2) return 0;
            char c = arr2[i];
            int j = 0;
            while(j < n1) {
                if(arr1[j] == c) j++;
                else return c - arr1[j];
            }
            while(i < n2) {
                if(arr2[i] == c) i++;
                else return arr2[i] - c;
            }
            return 0;
        }

    }


    public String largestNumber(int[] nums) {
        if(nums.length == 0) return null;
        int n = nums.length;
        String arr[] = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, new StringComparator());
        String res = "";
        boolean zero = true;
        for(int i = 0; i < n; i++) {
            if(arr[i].equals("0") == false) {
                zero = false;
            }
            res += arr[i];
        }
        if(zero) return "0";
        return res;
    }

}
