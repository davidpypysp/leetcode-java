package com.shiping.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
	
	
	public boolean isValid(String s) {
		Stack<String> st = new Stack<String>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				st.add(c + "");
			}
			else if(c == ')' || c == '}' || c == ']') {
				if(st.isEmpty()) return false;
				String left = st.pop();
				String right = c + "";
				if(!((left.equals("(") && right.equals(")")) || (left.equals("[") && right.equals("]")) || (left.equals("{") && right.equals("}")))) return false;
			}
			if(i + 1 == s.length() && !st.isEmpty()) return false;
		}
		return true;
	}

}
