package com.shiping.leetcode.hard;

import java.util.Stack;

/**
 * Created by davidpy on 5/25/16.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int max = 0;
        while(i <= n) {
            if(st.isEmpty() || i != n && heights[i] > heights[st.peek()]) {
                st.push(i++);
            }
            else {
                int h = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max, h * (i - left - 1));
            }
        }
        return max;
    }
}
