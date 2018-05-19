package exam;

import java.util.Arrays;
import java.util.Scanner;

public class JD2_shoppingList {
	private static int MAX = 100000;
	private static int[] buffer = new int[100001]; 
	
	private static int luckyNumberCount(int n) {
		int cnt = 0;
//System.out.printf("小于等于%d的幸运数：", n);
		for (int x = 1; x <= n; x++) {
			if (isLucky(x)) {
				for (int i = x; i <= n; i++) {
					buffer[i]++;
				}
//System.out.print(x + "  ");
				cnt++;
			}
		}
//System.out.println();
		return cnt;
	}
	
	private static boolean isLucky(int x) {
		int fx = 0, gx = 0;
		char[] chSeq = Integer.toString(x).toCharArray();
		for (char ch : chSeq) {
			fx += (ch - '0');
		}
		
		chSeq = Integer.toBinaryString(x).toCharArray();
		for (char ch : chSeq) {
			gx += (ch == '1') ? 1 : 0;
		}
		return fx == gx;
	}

	public static void main(String[] args) {
		Arrays.fill(buffer, 0);
		luckyNumberCount(MAX);
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			ans[i] = buffer[n];
		}
		
		for (int a : ans) {
			System.out.println(a);
		}
		sc.close();
	}


}
