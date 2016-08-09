package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/6/16.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "98";
        String num2 = "9";
        new MultiplyStrings().multiply(num1, num2);
    }


    public String multiply(String num1, String num2) {
        int neg = 1;
        if(num1.charAt(0) == '-') {
            neg *= -1;
            num1 = num1.substring(1);
        }
        if(num2.charAt(0) == '-') {
            neg *= -1;
            num2 = num2.substring(1);
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int arr[] = new int[len1+len2];
        int l = 0;

        String res = "";
        for(int i = len2-1; i >= 0; i--) {
            int v2 = num2.charAt(i) - '0';
            int k = len2 - 1 - i;
            for(int j = num1.length()-1; j >= 0; j--) {
                int v1 = num1.charAt(j) - '0';
                int v3 = v1 * v2;
                arr[k] += v3 % 10;
                if(arr[k] >= 10) {
                    arr[k] %= 10;
                    arr[k+1]++;
                }
                arr[k+1] += v3 / 10;
                if(arr[k+1] >= 10) {
                    arr[k+1] %= 10;
                    arr[k+2]++;
                }
                k++;
            }

        }
        if(arr.length > 1 && arr[arr.length-2] >= 10) {
            arr[arr.length-2] %= 10;
            arr[arr.length-1]++;
        }

        boolean preZero = true;
        for(int i = arr.length-1; i >= 0; i--) {
            if(preZero && arr[i] == 0) continue;
            preZero = false;
            res += arr[i] + "";
        }

        if(res == "") return "0";
        if(neg == -1) res = "-" + res;
        return res;
    }
}
