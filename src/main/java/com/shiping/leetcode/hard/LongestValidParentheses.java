package com.shiping.leetcode.hard;

import java.util.Stack;

/**
 * Created by davidpy on 5/18/16.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "((()(()";
        new LongestValidParentheses().longestValidParentheses(s);
    }

    public int longestValidParentheses(String s) {
        int max=0,start=0;
        Stack<Integer> stack=new Stack();
        int[] a=new int[s.length()];
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='(') stack.push(i);
            else if(!stack.empty()){
                start=stack.pop();
                a[i]=i-start+1;
                if(start>1) a[i]+=a[start-1];
                max=Math.max(max,a[i]);
            }
        }
        return max;

    }
}
