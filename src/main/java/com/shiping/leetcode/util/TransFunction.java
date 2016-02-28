package com.shiping.leetcode.util;

/**
 * Created by davidpy on 16/2/27.
 */
public class TransFunction {
    public char[][] StringArray2Char2D(String s[]) {
        int row = s.length;
        int col = s[0].length();
        char[][] ch = new char[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                ch[i][j] = s[i].charAt(j);
            }
        }
        return ch;
    }
}
