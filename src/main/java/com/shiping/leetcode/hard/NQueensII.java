package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/5/16.
 */
public class NQueensII {
    boolean board[][];
    int res = 0;

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        dfs(0, n);
        return res;
    }

    void dfs(int y, int n) {
        if(y == n) {
            res++;
            return;
        }

        for(int x = 0; x < n; x++) {
            if(valid(y, x, n) == true) {
                board[y][x] = true;
                dfs(y+1, n);
                board[y][x] = false;
            }
        }
    }

    boolean valid(int y, int x, int n) {
        for(int i = 0; i < y; i++) {
            if(board[i][x]  == true) return false;
        }
        for(int i = y-1, j = x-1; j >= 0 && i >= 0; i--, j--) {
            if(board[i][j] == true) return  false;
        }
        for(int i = y-1, j = x+1; j < n && i >= 0; i--, j++) {
            if(board[i][j] == true) return  false;
        }
        return true;
    }
}
