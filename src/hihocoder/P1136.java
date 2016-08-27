package hihocoder;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2016 下午1:18:14
 * moyong
 */

/*
 * 信号－模块
 */
public class P1136 {

	public static void main(String[] args) throws IOException {
		//InputStream inputStream = new FileInputStream("in.txt");
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task slover = new Task();
		int testNumber = in.nextInt();
		slover.solve(testNumber, in, out);
		out.close();
	}
	
	static class Task {
		final int N = 100005;
		final int MOD = 142857;
		int[] cnt = new int[N];
		int[] du = new int[N];
		int[] mp = new int[N];
		Tree tr = new Tree();
		Queue<Integer> q = new LinkedList();
		public void solve(int testNumber, InputReader in, PrintWriter out)
				throws IOException {
			while (testNumber-- > 0) {
				int n = in.nextInt();
				int m = in.nextInt();
				for (int i = 0; i < N; ++i) {
					cnt[i] = 0;
					du[i] = 0;
				}
				for (int i = 0; i < m; ++i) {
					int v = in.nextInt();
					cnt[v] += 1;
				}
				tr.init();
				for (int i = 0; i < n; ++i) {
					mp[i] = in.nextInt();
					int k = in.nextInt();
					for (int j = 0; j < k; ++j) {
						int v = in.nextInt();
						tr.add(mp[i], v);
						du[v]++;
					}
				}
				for (int i = 0; i < N; ++i) {
					if (du[i] == 0) {
						q.add(i);
					}
				}
				while (!q.isEmpty()) {
					int u = q.poll();
					for (int i = tr.head[u]; i != -1; i = tr.eg[i].next) {
						int v = tr.eg[i].v;
						cnt[v] = (cnt[u] + cnt[v]) % MOD;
						du[v]--;
						if (du[v] == 0) {
							q.add(v);
						}
					}
				}
				for (int i = 0; i < n; ++i) {
					out.print(cnt[mp[i]]+(i==n-1?"\n":" "));
				}
			}
		}
		private class Tree {
			int[] head = new int[N];
			Node[] eg = new Node[3*N];
			int cnt;
			public Tree() {
				for (int i = 0; i < N; ++i) {
					eg[i] = new Node();
				}
			}
			public void init() {
				for (int i = 0; i < N; ++i) {
					head[i] = -1;
				}
				cnt = 0;
			}
			public void add(int u,int v) {
				eg[cnt].v = v;
				eg[cnt].next = head[u];
				head[u] = cnt++;
			}
			private class Node {
				int v,next;
			}
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
	
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
	
		public String nextLine() throws IOException {
			return reader.readLine();
		}
	
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
	
		public int nextInt() {
			return Integer.parseInt(next());
		}
	
		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
