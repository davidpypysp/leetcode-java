package com.shiping.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shipingci on 7/29/16.
 */
public class ImplementStackUsingQueues {
    // Push element x onto stack.
    Queue<Integer> queue = new LinkedList<Integer>();
    Queue<Integer> tmp = new LinkedList<Integer>();

    public void push(int x) {
        queue.add(x);

    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue.size() > 1) {
            tmp.add(queue.remove());
        }
        queue.remove();
        while(tmp.isEmpty() == false) {
            queue.add(tmp.remove());
        }

    }

    // Get the top element.
    public int top() {
        int res = 0;
        while(queue.isEmpty() == false) {
            res = queue.remove();
            tmp.add(res);
        }
        while(tmp.isEmpty() == false) {
            queue.add(tmp.remove());
        }
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
