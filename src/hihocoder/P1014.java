package hihocoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P1014 {
	private static int N;  // 词条个数
	private static int T;  // 询问次数
	private static int R = 26;  // 儿子分支数
	private static Node root;
	private static Node[] nodes = new Node[1000000];  // 预先new出足够多的 Trie树节点
	private static int cursor = 0;
	
	// 对应 P733 的三种情况
	private static Node get(Node y, String key, int d) {
		if (y == null)	return null;
		if (d == key.length())	return y;
		char c = key.charAt(d);
		return get(y.next[c - 97], key, d + 1);  // next[c] 即 next[115]			
	}
	
	public static void put(String key, int val) {
		root = put(root, key, val, 0);
	}

	// 对应 P734 的两种情况
	private static Node put(Node x, String key, int val, int d) {
		if (x == null)	
			x = nodes[cursor++];
		
		x.pre++;
		if (d == key.length()) {
			return x;
		}
		
		char c = key.charAt(d);
		x.next[c - 97] = put(x.next[c - 97], key, val, d + 1);
		return x;
	}
		
	public static int numOfKeysWithPrefix(String pre) {
		Node x = get(root, pre, 0);
		if (x != null)		return x.pre;
		return 0;
	}

	private static class Node {
		private int pre = 0;  // 以“从根节点到该节点构成的字符串”为前缀的单词的个数
		private Node[] next = new Node[R];  // all links
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String key;
		
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = new Node();
		
		N = in.nextInt();		
		for (int i = 0; i < N; i++) {
			key = in.next();
			put(key, i + 1);
		}
		
		T = in.nextInt();
		for (int i = 0; i < T; i++) {
			key = in.next();
			System.out.println(numOfKeysWithPrefix(key));
		}
		
		out.close();
	}
	
	private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

    }

}

