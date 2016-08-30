package lintcode.dp;

public class P114 {
	int uniquePaths(int m, int n) {
		if (m < 1 || n < 1)    return 0;
		
		int[][] dp = new int[m][n];
		
		dp[m - 1][n - 1] = 1;  // position End
		for (int j = n - 2; j >= 0; j--) {
			dp[m - 1][j] = dp[m - 1][j + 1];  // last row
		}
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = dp[i + 1][n - 1];  // last column
		}
		
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		
		return dp[0][0];
	}

}
