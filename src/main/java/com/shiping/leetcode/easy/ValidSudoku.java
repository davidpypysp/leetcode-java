package com.shiping.leetcode.easy;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++) {
			int vis[] = new int[10];
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					vis[board[i][j] - '0']++;
					if(vis[board[i][j] - '0'] > 1) return false;
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			int vis[] = new int[10];
			for(int j = 0; j < 9; j++) {
				if(board[j][i] != '.') {
					vis[board[j][i] - '0']++;
					if(vis[board[j][i] - '0'] > 1) return false;
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			int y = (i / 3) * 3, x = (i % 3) * 3;
			int vis[] = new int[10];
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					int p = y + j, q = x + k;
					if(board[p][q] != '.') {
						vis[board[p][q] - '0']++;
						if(vis[board[p][q] - '0'] > 1) return false;
					}
				}
			}
		}
		return true;
	}

}
