package com.shiping.leetcode.medium;

import java.util.Stack;

/**
 * Created by shipin on 2015/8/7.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(tokens[i].equals("+")) {
                    stack.push(num1 + num2);
                }
                else if(tokens[i].equals("-")) {
                    stack.push(num1 - num2);
                }
                else if(tokens[i].equals("*")) {
                    stack.push(num1 * num2);
                }
                else if(tokens[i].equals("/")) {
                    stack.push(num1 / num2);
                }
            }
            else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
