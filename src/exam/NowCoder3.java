package exam;

import java.util.Scanner;

public class NowCoder3 {

	private static class Cash {
		int val, miW, mxW;
		
		Cash(int a, int b, int c) {
			val = a; miW = b; mxW = c;
		}
		public String toString() {
			return val + " " + miW + " " + mxW;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Cash[] cashes = new Cash[M];
			for (int i = 0; i < M; i++) {
				cashes[i] = new Cash(sc.nextInt(), sc.nextInt(), sc.nextInt());
				System.out.println(cashes[i]);
			}
			
		}
		sc.close();
	}

}
