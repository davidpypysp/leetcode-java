package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/8/16.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int dx[] = {1,0,-1,0}; //right, down, left, up
        int dy[] = {0, 1, 0, -1};
        int k = 0;
        int right = n, down = m, left = 0, up = 0;
        int y = 0, x = 0;
        while(true) {
            res.add(matrix[y][x]);
            if(false == (x + dx[k] >= left && x + dx[k] < right && y + dy[k] >= up && y + dy[k] < down)) {
                k = (k+1) % 4;
                switch (k) {
                    case 0:
                        left++;
                        break;
                    case 1:
                        up++;
                        break;
                    case 2:
                        right--;
                        break;
                    case 3:
                        down--;
                        break;
                }
                if(left == right || up == down) break;
            }
            x += dx[k];
            y += dy[k];
        }
        return res;
    }
}
