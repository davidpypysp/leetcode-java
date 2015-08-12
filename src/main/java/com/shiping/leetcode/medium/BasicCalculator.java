package com.shiping.leetcode.medium;

import java.util.ArrayList;

/**
 * Created by shipin on 2015/8/6.
 */
public class BasicCalculator {
    ArrayList<String> list;
    int index = 0;

    public int calculate(String s) {
        toList(s);
        return f();
    }


    public int f() {
        int ans = 0;
        int sign = 1;

        do{
            if( list.get(index).equals("(") ) {
                index++;
                ans += sign * f();
            }
            else { // is digit
                int num = Integer.parseInt(list.get(index));
                ans += sign * num;
            }

            index++;
            if(index >= list.size()) return ans;
            String op = list.get(index);
            if(op.equals(")")) return ans;
            else if(op.equals("+")) sign = 1;
            else if(op.equals("-")) sign = -1;
            index++;
        }while(true);
    }


    public void toList(String input) {
        list = new ArrayList<String>();
        String element = "";
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == ' ') continue;
            element += c + "";
            if(i+1 == input.length() || c == '+' || c == '-' || c == '(' || c == ')') {
                list.add(element);
                element = "";
                continue;
            }
            char cn = input.charAt(i+1);
            if(cn == ' ' || cn == '+' || cn == '-' ||  cn == '(' || cn == ')') { // element is a total number
                list.add(element);
                element = "";
            }
        }
    }
}
