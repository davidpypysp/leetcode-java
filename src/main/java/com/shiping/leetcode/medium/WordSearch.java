package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/4/16.
 */
public class WordSearch {
    public static void main(String[] args) {
        String word = "cdba";
        String s[] = {"ab", "cd"};
        char[][] board = new char[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                board[i][j] = s[i].charAt(j);
            }
        }
        new WordSearch().exist(board, word);
    }


    int dx[] = new int[]{0, -1, 0, 1};
    int dy[] = new int[]{1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        char[] arr = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean vis[][] = new boolean[board.length][board[0].length];
                if(dfs(board, i, j, arr, vis, 0) == true) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int y, int x, char[] arr, boolean vis[][], int index) {
        vis[y][x] = true;
        if(index == arr.length - 1 && arr[index] == board[y][x]) return true;
        if(board[y][x] != arr[index]) {
            vis[y][x] = false;
            return false;
        }
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if(ny >= 0 && ny < board.length && nx >= 0 && nx < board[0].length && !vis[ny][nx]) {
                if(dfs(board, ny, nx, arr, vis, index+1) == true) return true;
            }
        }
        vis[y][x] = false;
        return false;

    }
}
