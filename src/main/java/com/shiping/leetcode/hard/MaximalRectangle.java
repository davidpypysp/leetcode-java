package com.shiping.leetcode.hard;

import java.util.Stack;

/**
 * Created by davidpy on 5/24/16.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int heights[] = new int[m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

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
