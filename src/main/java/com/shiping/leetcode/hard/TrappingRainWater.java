package com.shiping.leetcode.hard;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

import java.util.Stack;

/**
 * Created by shipingci on 7/28/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        Stack<H> stack = new Stack<H>();
        stack.push(new H(height[0], 0));
        int res = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] < stack.peek().val) {
                stack.push(new H(height[i], i));
            } else {
                int preHeight = 0;
                while(!stack.isEmpty()) {
                    H h = stack.peek();
                    if(h.val <= height[i]) {
                        res += (i-h.index-1) * (h.val - preHeight);
                        preHeight = h.val;
                        stack.pop();
                    } else {
                        res += (i-h.index-1) * (height[i] - preHeight);
                        stack.push(new H(height[i], i));
                        break;
                    }
                }
                if(stack.isEmpty()) {
                    stack.push(new H(height[i], i));
                }
            }
        }
        return res;

    }

    class H {
        int val;
        int index;
         H(int val, int index) {
             this.val = val;
             this.index = index;
         }
    }
}
