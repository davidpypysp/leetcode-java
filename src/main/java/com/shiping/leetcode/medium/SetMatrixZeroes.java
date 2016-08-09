package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/7/16.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0},
                {1}
        };
        new SetMatrixZeroes().setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        if(matrix == null|| matrix.length == 0 ) return;
        int n = matrix.length, m = matrix[0].length;
        boolean preLineZero = false;
        for(int i = 0; i < n; i++) {
            boolean setLineZero = false;
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    setLineZero = true;
                    break;
                }

            }
            for(int j = 0; j < m; j++) {
                if(setLineZero == true) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
                if(i > 0) {
                    if(preLineZero == true && matrix[i-1][j] > 0) {
                        if(setLineZero == false) matrix[i][j] = 0;
                        else matrix[i][j] = 1;
                        matrix[i - 1][j] = 0;
                    } else if(preLineZero == false && matrix[i-1][j] == 0) {
                        if(setLineZero == false) matrix[i][j] = 0;
                        else matrix[i][j] = 1;
                    }
                }
            }
            preLineZero = setLineZero;
        }
        if(preLineZero) {
            for(int j = 0; j < m; j++) {
                if(matrix[n-1][j] == 1) {
                    for(int i = 0; i < n; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        } else {
            for(int j = 0; j < m; j++) {
                if(matrix[n-1][j] == 0) {
                    for(int i = 0; i < n; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return;
    }

}
