package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/17/16.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        if(matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int d[][] = new int[row][col];
        int ans = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    d[i][j] = 1;
                    if(i - 1 >= 0 && matrix[i-1][j] == '1' && j - 1 >= 0 && matrix[i][j-1] == '1') {
                        int up = d[i-1][j];
                        int left = d[i][j-1];
                        int l = Math.min(up, left);
                        if(matrix[i-l][j-l] == '1')
                            d[i][j] = l + 1;
                        else
                            d[i][j] = l;
                    }
                }
                ans = Math.max(ans, d[i][j] * d[i][j]);
            }
        }
        return ans;
    }
}
