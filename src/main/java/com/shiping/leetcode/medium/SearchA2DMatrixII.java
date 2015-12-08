package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/22.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y = 0, x = matrix[0].length - 1;
        while(y < matrix.length && x >= 0) {
            if(target == matrix[y][x]) return true;
            if(target > matrix[y][x]) y++;
            else if(target < matrix[y][x]) x--;
        }
        return false;
    }

}
