package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 16/2/26.
 */
public class NumberOfIslands {
    int MAX = 1000;
    int dir[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};




    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        boolean vis[][] = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    dfs(grid, vis, i, j, row, col);
                }
            }
        }

        return ans;
    }

    void dfs(char[][] grid, boolean[][] vis, int y, int x, int row, int col) {
        vis[y][x] = true;
        for(int k = 0; k < 4; k++) {
            int ny = y + dir[k][0];
            int nx = x + dir[k][1];
            if(ny >= 0 && ny < row && nx >= 0 && nx < col && grid[ny][nx] == '1' && !vis[ny][nx]) {
                dfs(grid, vis, ny, nx, row, col);
            }
        }
    }
}
