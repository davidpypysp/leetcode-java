package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/21.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, down = matrix.length;
        while(up < down) {
            int mid = (up + down) / 2;
            if( target >= matrix[mid][0] && (mid + 1 == down || target < matrix[mid + 1][0]) ) {
                int l = 0, r = matrix[mid].length;
                boolean flag = false;
                while(l < r) {
                    int m = (l + r) / 2;
                    if(target == matrix[mid][m]) {
                        return true;
                    }
                    else if(target < matrix[mid][m]) {
                        r = m;
                    }
                    else {
                        l = m + 1;
                    }
                }
                if(flag == false) break;
            }
            else if(target < matrix[mid][0]) {
                down = mid;
            }
            else {
                up = mid + 1;
            }
        }
        return false;
    }
}
