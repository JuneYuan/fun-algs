package exam;

import java.util.List;

public class Splunk2_appleTree {
	private boolean[] hasApple;  // whether a node has any apple on it
	private List<Integer>[] edges;  // adjacency list: edges[i] contains children of node i
	
	private class Triple {
		int mx1;  // max apples count starting from current node
		int mx2;  // 2nd max apples count starting from current node
		int mx;   // max apples count rooted in current node
		
		Triple() {}
		Triple(int mx1, int mx2, int mx) {
			this.mx1 = mx1;
			this.mx2 = mx2;
			this.mx = mx;
		}
	}
	
	public int collectApples(int N, int K, int[] applesAtNodes, int[][] connectedNodes) {
		hasApple = new boolean[N + 1];
		edges = (List<Integer>[]) new Object[N + 1];
		
		// init hasApple[] according to applesAtNodes[]
		for (int i = 1; i <= N; i++) {
			hasApple[i] = false;
		}
		for (int i = 0; i < K; i++) {
			hasApple[applesAtNodes[i]] = true;
		}
		
		// init edges according to connectedNodes[]
		for (int i = 0; i < N - 1; i++) {
			int u = connectedNodes[i][0];
			int v = connectedNodes[i][1];
			edges[u].add(v);
			edges[v].add(u);
		}
		
		// get the result
		Triple result = dfs(1, -1);
		return result.mx;
	}

	// duty
	// arg1: 
	// arg2:
	Triple dfs(int u, int f) {
		Triple tr1 = new Triple(0, 0, 0);
		for (int v : edges[u]) {
			if (v == f)  continue;
			Triple tr2 = dfs(v, u);
			if (tr2.mx1 > tr1.mx1) {
				if (tr2.mx2 > tr1.mx1) {
					tr1.mx2 = tr2.mx2;
				} else {
					tr1.mx2 = tr1.mx1;
				}
				tr1.mx1 = tr2.mx1;
				
			} else if (tr2.mx2 > tr1.mx2) {
				tr1.mx2 = tr2.mx2;
			}
			
			if (tr2.mx > tr1.mx) {
				tr1.mx = tr2.mx;
			}
		}
		
		int tmp = hasApple[u] ? 1 : 0;
		if (tr1.mx1 + tr1.mx2 + tmp > tr1.mx) {
			tr1.mx = tr1.mx1 + tr1.mx2 + tmp;
		}
		
		if (tr1.mx1 != 0) {
			tr1.mx2 += tmp;
		}
		
		tr1.mx1 += tmp;
		return tr1;
	}
}
