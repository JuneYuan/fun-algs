import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class P1153 {
	
	private static int T;	// # of testcases
	private static int K, length;	// testcase and its length
	private static String strK;
	private static HashMap<Integer, Integer> hm;  // <digit, value>
	private static int result;
	
	//private static Stack<Integer> result;
	
	private static boolean[][] go = {
			{true , false, false, false, false, false, false, false, false, false},  // 0
			{true , true , true , true , true , true , true , true , true , true },
			{true , false, true , true , false, true , true , false, true , true },
			{false, false, false, true , false, false, true , false, false, true },  // 3
			{true , false, false, false, true , true , true , true , true , true },
			{true , false, false, false, false, true , true , false, true , true },
			{false, false, false, false, false, false, true , false, false, true },  // 6
			{true , false, false, false, false, false, false, true , true , true },
			{true , false, false, false, false, false, false, false, true , true },
			{false, false, false, false, false, false, false, false, false, true },  // 9
		};  // 可达矩阵
		
	
	public static void numericKeypad(Scanner scanner) {
		T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			K = scanner.nextInt();
			strK = Integer.toString(K);
			length = strK.length();
			hm = new HashMap<>();
			
			dfs(0, 1, false, 0);
			//dfs(0, 1, false);
		}
	}
	
	private static boolean dfs(int depth, int last, boolean below, int lev) {
String indent = "";
for (int i = 0; i < lev; i++)
	indent += "            ";
StdOut.printf("%sdfs(%d, %d, %s)\n", indent, depth, last, below ? "true" : "false");

StdOut.printf("%s    If (depth=%d >= %d=length)", indent, depth, length);
		if (depth >= length) {
StdOut.printf(" 成立");
			System.out.println();
			for (int i = 0; i < hm.size(); i++)
				System.out.print(hm.get(i));
			System.out.println();
StdOut.printf("%s", toInt() < K ? "结束\n" : "失败\n");

			return toInt() < K;
		}
StdOut.println(" 不成立");

StdOut.printf("%s    If (below=true)", indent);
		if (below == true) {
StdOut.println(" 成立");
			for (int i = depth, j = 9; i < length; i++, j = 9) {
				while (go[last][j] == false && j > 0)
					j--;
				hm.put(i, j);
			}

			System.out.println();
			for (int i = 0; i < hm.size(); i++)
				System.out.print(hm.get(i));
			System.out.println();
			return toInt() < K;
				
		}
StdOut.println(" 不成立");		

StdOut.printf("%s    i=", indent);			
		for (int i = 9; i >= 0; i--) {
StdOut.print(i + ",");			
			int digit = strK.charAt(depth) - '0';
			
			if (i <= digit && go[last][i]) {
				hm.put(depth, i);
StdOut.printf("\n%s        If(%d <= %d=K[%d] && go[%d][%d]==true) 成立\n", indent, i, digit, depth, last, i);
StdOut.printf("%s            result[%d]=%d\n", indent, depth, i);

				if (dfs(depth + 1, i, i < digit, lev + 1))
					return toInt() < K;	
			}
		}
		
StdOut.printf("失败\n%s\b\b\b\b\b\b\b\bi=", indent);  // 接的是 Line (this - 13)
		return false;
	}

	private static int toInt() {
		int ret = 0;
		for (int i = hm.size() - 1, t = 1; i >= 0; i--, t*=10) {
			ret += hm.get(i) * t;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		numericKeypad(scanner);
		
		scanner.close();
	}

}
