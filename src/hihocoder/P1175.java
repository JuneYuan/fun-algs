package hihocoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/*
 * 拓扑排序应用
 */
public class P1175 {
	private static int N, M;
	private static List<Integer> sources;
	private static boolean[] marked;
	private static Deque<Integer> order;  // topological order, i.e. reversePost
	private static int[] counts;
	private static int total;
	
	private static void topoSort(Graph G) {
		order = new ArrayDeque<Integer>();
		counts = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 1; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	
	}

	private static void calculate(Graph G) {
		for (int v : sources)
			counts[v] = 1;		
		total = sources.size() % 142857;
		for (int v : order) {
			for (int w : G.adj(v)) {
				counts[w] = (counts[w] + counts[v]) % 142857;
				total = (total + counts[v]) % 142857;
			}
		}
	}
	
	private static void dfs(Graph G, int v) {	
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);

		order.push(v);
	}

	private static class Graph {
		final int V;
		int E;
		List<Integer>[] adj;
		
		Graph(int V) {
			this.V = V;  this.E = 0;
			adj = (ArrayList<Integer>[]) new ArrayList[V];
			for (int v = 0; v < V; v++)
				adj[v] = new ArrayList<>();
		}
		
		Graph(Scanner sc) {
			this(N + 1);
			for (int i = 0; i < M; i++) {
				int v = sc.nextInt(), w = sc.nextInt();
				addEdge(v, w);
			}
		}
	
		void addEdge(int v, int w) { adj[v].add(w);  E++; }
		int V() { return V; }
		
		Iterable<Integer> adj(int v) { return adj[v]; }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  M = sc.nextInt();
		int K = sc.nextInt();
		sources = new ArrayList<>();
		for (int i = 0; i < K; i++)
			sources.add(sc.nextInt());
		Graph G = new Graph(sc);
			
		topoSort(G);
		calculate(G);
		
		System.out.println(total);			

		sc.close();
	}
}
