package com.shiping.leetcode.medium;

import java.util.Stack;

/**
 * Created by davidpy on 5/19/16.
 */
public class BasicCaculatorII {
    // 3+3+3*15+3*3/3+14*2
    public static void main(String[] args) {
        String s = "1 + 1";
        new BasicCaculatorII().calculate(s);
    }


    public int calculate(String s) {
        int n = s.length();
        int i = 0;
        char[] c = s.toCharArray();
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> calStack = new Stack<Character>();
        while(i < n) {
            if(Character.isDigit(c[i])) {
                int val = c[i] - '0';
                while( i+1 < n && Character.isDigit(c[i+1]) ) {
                    val = val * 10 + (c[i+1] - '0');
                    i++;
                }
                numStack.push(val);
                if(!calStack.isEmpty() && (calStack.peek() == '*' || calStack.peek() == '/')) {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    int cal = calStack.pop();
                    if(cal == '*') numStack.push(num1 * num2);
                    else numStack.push(num1 / num2);

                }
            }
            else if(c[i] == '+' || c[i] == '-') {
                if(!calStack.isEmpty() && (calStack.peek() == '+' || calStack.peek() == '-')) {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    int cal = calStack.pop();
                    if(cal == '+') numStack.push(num1 + num2);
                    else numStack.push(num1 - num2);
                }
                calStack.push(c[i]);
            }
            else if(c[i] == '*' || c[i] == '/') {
                calStack.push(c[i]);
            }
            i++;
        }
        if(!calStack.isEmpty() && (calStack.peek() == '+' || calStack.peek() == '-')) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            int cal = calStack.pop();
            if(cal == '+') numStack.push(num1 + num2);
            else numStack.push(num1 - num2);
        }
        return numStack.pop();

    }
}
