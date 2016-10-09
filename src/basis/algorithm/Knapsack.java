package basis.algorithm;

import java.util.Arrays;

public class Knapsack {
	
	// 01 backpack with small datasets (O(nW), W is small)
	public static int backpack(int W, int[] w, int[] v, boolean[] itemTake) {
		int N = w.length;
		int[][] dp = new int [N + 1][W + 1];
		boolean[][] matrix = new boolean[N + 1][W + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= W; j++) {
				if (w[i] > j) {
					// backpack cannot hold w[i]
					dp[i + 1][j] = dp[i][j];
				} else {
					dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
					matrix[i][j] = (dp[i][j - w[i]] + v[i] > dp[i][j]);
				}
			}
		}
		
		// determine which items to take
		for (int i = N - 1, j = W; i >= 0; i--) {
			if (matrix[i][j]) {
				itemTake[i] = true;
				j -= w[i];
			} else {
				itemTake[i] = false;
			}
		}
		
		return dp[N][W];
	}

	// 01 backpack with big datasets (O(n/sigma{v}), W is very big)
	public static int backpack2(int W, int[] w, int[] v) {
		int N = w.length;
		// sum of value array
		int V = 0;
		for (int i : v) {
			V += i;
		}
		// initialize
		int[][] dp = new int[N + 1][V + 1];
		for (int[] i : dp) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		dp[0][0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= V; j++) {
				if (v[i] > j) {
					dp[i + 1][j] = dp[i][j];
				} else {
					dp[i + 1][j] = Math.min(dp[i][j], dp[i][j - v[i]] + w[i]);
				}
			}
		}
		
		// search for the largest i that dp[N][i] <= W
		for (int i = V; i >= 0; i--) {
			if (dp[N][i] <= W)	return i;
		}
		return 0;
	}

	// repeated backpack 
	public static int backpack3(int W, int[] w, int[] v) {
		int N = w.length;
		int[][] dp = new int[N + 1][W + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= W; j++) {
				if (w[i] > j) {
					dp[i + 1][j] = dp[i][j];
				} else {
					dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
				}
			}
		}
		
		return dp[N][W];
	}
	
	public static void main(String[] args) {
		int[] w1 = new int[]{2, 1, 3, 2};
		int[] v1 = new int[]{3, 2, 4, 2};
		int W1 = 5;
		boolean[] itemTake = new boolean[w1.length + 1];
		System.out.println("Testcase for 01 backpack.");
		int bp1 = backpack(W1, w1, v1, itemTake);  // bp1 should be 7
		System.out.println("Maximum value: " + bp1);
		for (int i = 0; i < itemTake.length; i++) {
			if (itemTake[i]) {
				System.out.println("item " + i + ", weight " + w1[i] + ", value " + v1[i]);
			}
		}
		
		System.out.println("Testcase for 01 backpack with large W.");
		int bp2 = backpack2(W1, w1, v1);	// b2 should be 7
		System.out.println("Maximum value: " + bp2);
		
		int[] w3 = new int[]{3, 4, 2};
		int[] v3 = new int[]{4, 5, 3};
		int W3 = 7;
		System.out.println("Testcase for repeated backpack.");
		int bp3 = backpack3(W3, w3, v3);
		System.out.println("Maximum value: " + bp3);
	}
}
