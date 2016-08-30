package lintcode.dp;

import org.junit.Test;

public class P110 {
	int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)	return 0;
		if (grid[0] == null || grid[0].length == 0)	return 0;
		
		int M = grid.length;
		int N = grid[0].length;
		int[][] dp = new int[M][N];

		// position (0, 0)
		dp[0][0] = grid[0][0];
		// row 0
		for (int j = 1; j < N; j++) {
			dp[0][j] = grid[0][j] + dp[0][j - 1];
		}
		// column 0
		for (int i = 1; i < M; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
				
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				int curr = grid[i][j];
				dp[i][j] = curr + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[M - 1][N - 1];
	}
	
	@Test
	public void test() {
		int[][] grid = new int[][]{{1, 2},
					{1, 1}};
		int ret = minPathSum(grid);
		System.out.println(ret);
	}
}
