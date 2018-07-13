package leetcode1st.search;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

// 这是用 dfs 方式搜索，LintCode 能通过，LeetCode 会因数据量较大而报 java.lang.StackOverflowError 异常
public class P130SurroundRegions {
	private char[][] board;
	private int n, m;

    /**
     * solution1
     */
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

        
    @Test
    public void test() {		
		int N = 300;
		char[][] board = new char[N][N];		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				int t = StdRandom.uniform(2);
				char ch = 'O';
				// char ch = (t == 0) ? 'X' : 'O';
				board[i][j] = ch;
			}
		}

		System.out.println("board[][] before process...");
		display(board);
		
		solve(board);
		
		System.out.println("board[][] after process...");
		display(board);
	}
    
    private void display(char[][] board) {
    	for (char[] line : board) {
    		for (char ch : line) {
    			System.out.print(ch + " ");
    		}
    		System.out.println();
    	}
    }


    /**
     * solution2
     */
    public void unionFind(char[][] board) {
        if (board == null || board.length == 0)  return;

        n = board.length;
        m = board[0].length;
        UF uf = new UF(n * m + 1);
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        // first traverse: build the Union-Find-Set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < direction.length; d++) {
                    if (board[i][j] == 'O') {
                        // union surrounding sites to the virtual site
                        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                            uf.union(hash(i, j), n * m);
                        }

                        int newI = i + direction[d][0];
                        int newJ = j + direction[d][1];
                        if (newI >= 0 && newI < n
                                && newJ >= 0 && newJ < m
                                && board[newI][newJ] == 'O') {
                            uf.union(hash(i, j), hash(newI, newJ));
                        }
                    }

                }
            }
        }

        // second traverse: modify the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X')  ;
                else if (board[i][j] == 'O' && uf.connected(hash(i, j), n * m))  ;
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int hash(int i, int j) {
        return i * m + j;
    }

    private class UF {
        int[] id;
        int[] sz;

        public UF(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public void union(int p, int q) {
            if (connected(p, q))    return;

            int pid = find(p);
            int qid = find(q);
            if (sz[pid] > sz[qid]) {
                id[qid] = pid;
                sz[pid] += sz[qid];
            } else {
                id[pid] = qid;
                sz[qid] += sz[pid];
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int x){
            while (x != id[x]) {
                x = id[x];
            }
            return x;
        }
    }

}
