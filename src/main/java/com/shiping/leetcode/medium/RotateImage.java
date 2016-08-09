package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/8/16.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2},
                {3,4}
        };
        new RotateImage().rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1) return;
        int r = n-1;
        int y = 0, x = 0;
        while(y < n/2) {
            for(x = y; x < r; x++) {
                rotate4(matrix, y, x);
            }
            r--;
            y++;
        }
    }

    void rotate4(int[][] matrix, int y, int x) {
        int n = matrix.length;
        int pre = matrix[y][x];
        for(int i = 0; i < 4; i++) {
            int oldy = y;
            y = x;
            x = n - 1 - oldy;
            int cur = matrix[y][x];
            matrix[y][x] = pre;
            pre = cur;
        }
    }
}
