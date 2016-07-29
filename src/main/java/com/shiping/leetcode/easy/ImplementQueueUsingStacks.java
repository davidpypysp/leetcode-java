package com.shiping.leetcode.easy;

import java.util.Stack;

/**
 * Created by shipingci on 7/28/16.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> tmp = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);

    }

    // Removes the element from in front of queue.
    public void pop() {
        while(stack.size() > 1) {
            tmp.push((stack.pop()));
        }
        int res = stack.pop();
        while(tmp.isEmpty() == false) {
            stack.push(tmp.pop());
        }

    }

    // Get the front element.
    public int peek() {
        while(stack.size() > 1) {
            tmp.push((stack.pop()));
        }
        int res = stack.peek();
        while(tmp.isEmpty() == false) {
            stack.push(tmp.pop());
        }
        return res;

    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();

    }
}
