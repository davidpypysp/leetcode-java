package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/5/16.
 */
public class NQueens {
    boolean board[][];
    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        dfs(0, n);
        return res;
    }

    void dfs(int y, int n) {
        if(y == n) {
            List<String> list = new ArrayList<String>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }

        for(int x = 0; x < n; x++) {
            if(valid(y, x, n)) {
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
