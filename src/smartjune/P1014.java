package smartjune;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P1014 {
	private static int N;  // 词典大小
	private static int T;  // 询问次数
	
	private static int R = 256;
	private static Node root;
	
	// 对应 P733 的三种情况
	private static Node get(Node y, String key, int d) {
		if (y == null)	return null;
		if (d == key.length())	return y;
		char c = key.charAt(d);
		return get(y.next[c], key, d + 1);  // next[c] 即 next[115]			
	}
	
	public static void put(String key, int val) {
		root = put(root, key, val, 0);
	}

	// 对应 P734 的两种情况
	private static Node put(Node x, String key, int val, int d) {
		if (x == null)	x = new Node();
		if (d == key.length()) {
			x.val = val;
			x.dup++;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
		
	public static Iterable<String> keysWithPrefix(String pre){
		Queue<String> q = new LinkedList<String>();
		Node arg1 = get(root, pre, 0);
		collect(arg1, pre, q);
		return q;
	}
	
	private static void collect(Node x, String key, Queue<String> q) {
		if (x == null)	return;
		if (x.val != -1)
			for (int i = 0; i < x.dup; i++)
				q.add(key);
		for (char c = 0; c < R; c++)
			collect(x.next[c], key + c, q);
	}

	private static class Node {
		private int val;  // 如 "apple" 是第一个插入的，其 val 就为 1
		private Node[] next = new Node[R];  // all links
		private int dup = 0;  // 对应单词的重复次数
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String key;
		
		N = scanner.nextInt();		
		for (int i = 0; i < N; i++) {
			key = scanner.next();
			put(key, i + 1);
		}
		
		T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			key = scanner.next();
			List<String> it = (List)keysWithPrefix(key);
			
			System.out.println(it.size());
		}
		
		scanner.close();
	}
	
}
