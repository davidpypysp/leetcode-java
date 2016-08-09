package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/8/16.
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(3);
    }


    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0) return matrix;
        if(n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        int count = n-1;
        int y = 0, x = 0;
        int dx[] = {1,0,-1,0}; //right, down, left, up
        int dy[] = {0, 1, 0, -1};
        int k = 0;
        int index = 1;
        while(index <= n*n) {
            for(int i = 0; i < count; i++)
                matrix[y][x++] = index++;
            for(int i = 0; i < count; i++)
                matrix[y++][x] = index++;
            for(int i = 0; i < count; i++)
                matrix[y][x--] = index++;
            for(int i = 0; i < count; i++)
                matrix[y--][x] = index++;
            y++;
            x++;
            if(index == n * n) {
                matrix[y][x] = index;
                break;
            }
            count-=2;
        }
        return matrix;
    }
}
