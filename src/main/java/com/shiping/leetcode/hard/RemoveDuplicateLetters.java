package com.shiping.leetcode.hard;

import java.util.Stack;

/**
 * Created by davidpy on 5/13/16.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int count[] = new int[26];
        boolean vis[] = new boolean[26];
        Stack<Integer> stack = new Stack<Integer>();
        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for(char ch : s.toCharArray()) {
            int c = ch - 'a';
            if(stack.isEmpty()) {
                stack.push(c);
                vis[c] = true;
            }
            else if(vis[c] == false) {
                while(!stack.isEmpty() && c < stack.peek() && count[stack.peek()] > 0) {
                    vis[stack.peek()] = false;
                    stack.pop();
                }
                stack.push(c);
                vis[c] = true;
            }
            count[c]--;
        }
        String ans = "";
        for(int c : stack) {
            String ch = Character.toString((char)(c + 'a'));
            ans = ans + ch;
        }
        return ans;
    }
}
