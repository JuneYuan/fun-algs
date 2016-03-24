package smartjune;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/*
 * 拓扑排序
 */
public class P1174 {
	private static boolean[] marked;
	private static int[] edgeTo;
	private static boolean[] onStack;	
	private static Deque<Integer> cycle;

	private static void dfs(Graph G, int v) {
		onStack[v] = true;
		
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (hasCycle())		return;
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
			else if (onStack[w]) {
				for (int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		}
		
		onStack[v] = false;
	}

	private static Iterable<Integer> cycle() { return cycle; }
	
	public static boolean hasCycle() { return !cycle.isEmpty(); }

	private static class Graph {
		final int V;
		int E;
		List<Integer>[] adj;
		
		Graph(Scanner sc) {
			V = sc.nextInt() + 1;
			E = sc.nextInt();
			adj = (ArrayList<Integer>[]) new ArrayList[V];
			for (int v = 0; v < V; v++)
				adj[v] = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				int v = sc.nextInt(), w = sc.nextInt();
				addEdge(v, w);
			}
		}
	
		void addEdge(int v, int w) { adj[v].add(w); }
		int V() { return V; }
		
		Iterable<Integer> adj(int v) { return adj[v]; }
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(), N, M;
		for (int i = 0; i < T; i++) {
			Graph G = new Graph(scanner);
			
			marked = new boolean[G.V()];
			edgeTo = new int[G.V()];
			onStack = new boolean[G.V()];
			cycle = new ArrayDeque<>();
			for (int v = 1; v < G.V(); v++)
				if (!marked[v])
					dfs(G, v);
			
			System.out.println(hasCycle() ? "Wrong" : "Correct");
			cycle = null;
		}		
		scanner.close();
	}
}
