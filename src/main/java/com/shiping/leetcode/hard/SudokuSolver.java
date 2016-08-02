package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/2/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);

    }

    boolean dfs(char[][] board, int index) {
        if(index == 81) return true;
        int y = index / 9;
        int x = index % 9;
        if(board[y][x] != '.') {
            return dfs(board, index+1);
        }
        for(char c = '1'; c <= '9'; c++) {
            if(isValid(board, y, x, c)) {
                board[y][x] = c;
                if(dfs(board, index+1) == true) return true;
            }
            board[y][x] = '.';
        }

        return false;

    }

    boolean isValid(char[][] board, int y, int x, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[y][i] != '.' && board[y][i] == c) return false;
        }
        for(int i = 0; i < 9; i++) {
            if(board[i][x] != '.' && board[i][x] == c) return false;
        }
        int ly = 3 * (y/3), lx = 3 * (x/3);
        for(int i = ly; i < ly+3; i++) {
            for(int j = lx; j < lx+3; j++) {
                if(board[i][j] != '.' && board[i][j] == c) return false;
            }
        }
        return true;
    }
}
