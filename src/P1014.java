import java.util.ArrayList;
import java.util.Scanner;

public class P1014 {

	private static int n, m;
	private static Node trieTree = new Node();
	private static int cnt;  // count of Nodes
	// private static String[] dict;
	private static String entry, query;  // 词条和查询的前缀
	
	public static void trieTree(Scanner scanner) {
		n = scanner.nextInt();
		//dict = new String[n];
		for (int i = 0; i < n; i++) {
			entry = scanner.next();
			
			for (int j = 0, Node cursor = trieTree; j < entry.length(); j++) {
				char chara = entry.charAt(j);
				if (existed) {
					;
				} 
				else {
					;
				}
				
			}
		}
		
		m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			;
		}
	}

	private static class Node {
		int num = 0;
		char ch = '*';
		ArrayList<Node> children = new ArrayList<>();
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		trieTree(scanner);
		
		scanner.close();
	}

}
