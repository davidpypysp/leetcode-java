package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TransFunction;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by davidpy on 16/2/27.
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        String[] s = new String[]{
                "XOOOOOOOOOOOOOOOOOOO",
                "OXOOOOXOOOOOOOOOOOXX",
                "OOOOOOOOXOOOOOOOOOOX",
                "OOXOOOOOOOOOOOOOOOXO",
                "OOOOOXOOOOXOOOOOXOOX",
                "XOOOXOOOOOXOXOXOXOXO",
                "OOOOXOOXOOOOOXOOXOOO",
                "XOOOXXXOXOOOOXXOXOOO",
                "OOOOOXXXXOOOOXOOXOOO",
                "XOOOOXOOOOOOXXOOXOOX",
                "OOOOOOOOOOXOOXOOOXOX",
                "OOOOXOXOOXXOOOOOXOOO",
                "XXOOOOOXOOOOOOOOOOOO",
                "OXOXOOOXOXOOOXOXOXOO",
                "OOXOOOOOOOXOOOOOXOXO",
                "XXOOOOOOOOXOXXOOOXOO",
                "OOXOOOOOOOXOOXOXOXOO",
                "OOOXOOOOOXXXOOXOOOXO",
                "OOOOOOOOOOOOOOOOOOOO",
                "XOOOOXOOOXXOOXOXOXOO"

        };
        char[][] board = new TransFunction().StringArray2Char2D(s);
        new SurroundedRegions().solve(board);
    }

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if(board.length == 0) return;
        if(board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int i = 0; i < col; i++) {
            if(board[0][i] == 'O') bfs(board, 0, i);
            if(board[row - 1][i] == 'O') bfs(board, row - 1, i);
        }
        for(int i = 0; i < row - 1; i++) {
            if(board[i][0] == 'O') bfs(board, i, 0);
            if(board[i][col - 1] == 'O') bfs(board, i, col - 1);
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'V')
                    board[i][j] = 'O';
            }
        }

    }

    void bfs(char[][] board, int y, int x ) {
        int row = board.length;
        int col = board[0].length;
        Pos start = new Pos(y, x);
        Queue<Pos> queue = new LinkedList<Pos>();
        queue.add(start);
        board[y][x] = 'V';
        while(queue.isEmpty() == false) {
            Pos p = queue.poll();
            y = p.y;
            x = p.x;
            for(int k = 0; k < 4; k++) {
                int ny = y + dir[k][0];
                int nx = x + dir[k][1];
                if(ny >= 0 && ny < row && nx >= 0 && nx < col) {
                    if(board[ny][nx] == 'O'){
                        board[ny][nx] = 'V';
                        queue.add(new Pos(ny, nx));
                    }
                }
            }
        }
    }

    class Pos {
        int y;
        int x;
        Pos(int y, int x) {
            this. y = y;
            this. x = x;
        }
    }
}
