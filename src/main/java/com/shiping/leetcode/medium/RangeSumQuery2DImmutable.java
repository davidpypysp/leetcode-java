package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 4/19/16.
 */
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };

        RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable();
        r.NumMatrix(matrix);

    }

    public static int d[][];

    public void NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length, col = matrix[0].length;
        d = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0;j < col; j++) {
                d[i][j] = matrix[i][j];
                if(i == 0 && j - 1 >= 0) {
                    d[i][j] += d[i][j-1];
                }
                else if(j == 0 && i - 1 >= 0) {
                    d[i][j] += d[i-1][j];
                }
                else if(i > 0 && j > 0){
                    d[i][j] += d[i][j-1] + d[i-1][j] - d[i-1][j-1];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) return d[row2][col2];
        else if(row1 == 0) return d[row2][col2] - d[row2][col1 - 1];
        else if(col1 == 0) return d[row2][col2] - d[row1 - 1][col2];
        else return d[row2][col2] - d[row2][col1 - 1] - d[row1 - 1][col2] + d[row1 - 1][col1 - 1];
    }
}
