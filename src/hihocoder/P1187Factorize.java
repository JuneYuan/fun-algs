package hihocoder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1187Factorize {
	private static long N;
	private static Integer[] pTemp = new Integer[]{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	private static List<Integer> primes = Arrays.asList(pTemp);
	private static int num = 0;

	public static int factorization(long n) {
		num = 1;
		return dfs(n, 2, 0);
	}
	
	private static int dfs(long n, int p, int i) {
		if (p > n)		return num;
		
		while (n % (int)Math.pow(p, i+1) == 0) {
			i++;
		}
		num *= (i + 1);
		
		int k = primes.indexOf(p);
		int p1 = (int) primes.get(k + 1);
		return dfs(n / (int) Math.pow(p, i), p1, 0);
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextLong();
		int ret = 1;

		for (int i = 1; i <= N; i++) {
			if (factorization(i) > factorization(ret))
				ret = i;
		}
		System.out.println(ret);

		scanner.close();
	}
}
