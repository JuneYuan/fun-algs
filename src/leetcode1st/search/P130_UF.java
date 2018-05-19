package leetcode1st.search;

// 思路二：并查集
public class P130_UF {
    private int n, m;
    
    public void solve(char[][] board) {
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
