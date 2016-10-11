package leetcode.search;

import java.util.ArrayList;
import java.util.List;

// 这是 dfs 解法，LintCode 能通过，LeetCode 会因数据量较大而报 java.lang.StackOverflowError 异常
public class P130 {
	private char[][] board;
	private int n, m;

    private class Pair {
        int i, j;
        char ch;
        
        public Pair(int i, int j, char ch) {
            this.i = i;  this.j = j;  this.ch = ch;
        }
    }
    
    public void solve(char[][] board) {
        if (board.length == 0)  return;
        
    	this.board = board;
        n = board.length;
        m = board[0].length;
        
        // collect the bolder sites
        List<Pair> bolder = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            bolder.add(new Pair(0, j, board[0][j]));
            bolder.add(new Pair(n - 1, j, board[n - 1][j]));
        }
        for (int i = 1; i < n - 1; i++) {
            bolder.add(new Pair(i, 0, board[i][0]));
            bolder.add(new Pair(i, m - 1, board[i][m - 1]));
        }
        
        // detect all 'O' that connected to those 'O' on bolder
        for (Pair site : bolder) {
            if (site.ch == 'O') {
                dfs(site.i, site.j);
            }
        }
        
        // set the board sites accordingly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X')     ;
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(int x, int y) {
        board[x][y] = '#';
        
        int[][] direction = new int[][]{
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };
        for (int d = 0; d < 4; d++) {
            int xx = x + direction[d][0];
            int yy = y + direction[d][1];
            if (xx >= 0 && xx < n
                && yy >= 0 && yy < m
                && board[xx][yy] == 'O') {
                dfs(xx, yy);
            }
        }
    }

}
