package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipin on 2015/8/6.
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String input = "-2123*3444-4123*53*";

    }
    List<String> list;

    public List<Integer> diffWaysToCompute(String input) {
        toList(input);
        return g(0, list.size() - 1);
    }

    public List<Integer> g(int m, int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(m == n) {
           result.add( Integer.parseInt(list.get(m)) );
            return result;
        }

        for(int i = m; i <= n; i++) {
            String s = list.get(i);
            if( (s.equals("*") || s.equals("+") || s.equals("-")) == false ) continue;
            List<Integer> left = g(m, i-1);
            List<Integer> right = g(i+1, n);
            for(int l : left) {
                for(int r : right) {
                    int ans;
                    if(s.equals("*")) {
                        ans = l * r;
                    }
                    else if(s.equals("+")) {
                        ans = l + r;
                    }
                    else {
                        ans = l - r;
                    }
                    result.add(ans);
                }
            }
        }
        return result;
    }


    public void toList(String input) {
        list = new ArrayList<String>();
        String element = "";
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            element += c + "";
            if(i+1 == input.length() || c == '*' || c == '+' || c == '-') {
                list.add(element);
                element = "";
                continue;
            }
            char cn = input.charAt(i+1);
            if(cn == '*' || cn == '+' || cn == '-') { // element is a total number
                list.add(element);
                element = "";
            }
        }
    }

}
