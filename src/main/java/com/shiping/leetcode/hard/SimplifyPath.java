package com.shiping.leetcode.hard;

import java.util.Stack;

/**
 * Created by shipingci on 7/28/16.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String a = "/home//foo/";
        String arr[] = a.split("/");
        System.out.println("here");
    }

    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(".") || arr[i].equals("")) {
                continue;
            } else if(arr[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }
        int len = stack.size();
        String ans = "";
        while(stack.isEmpty() == false) {
            String s = stack.pop();
            ans = ("/" + s) + ans;
        }
        if(ans.equals("")) ans = "/";
        return ans;
    }
}
