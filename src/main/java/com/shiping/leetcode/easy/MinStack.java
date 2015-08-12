package com.shiping.leetcode.easy;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
		stack.push(x);
		if(minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);

	}
	
	public void pop() {
		int x = stack.pop();
		if(x == minStack.peek()) minStack.pop();
		
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}

}
