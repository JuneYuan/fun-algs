package problems.dp.lint.once;

import java.util.Arrays;

import org.junit.Test;

public class P115 {
	int uniquePaths(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)	return 0;
		if (obstacleGrid[0] == null || obstacleGrid[0].length == 0)	return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;		
		int[][] dp = new int[m][n];
		
		dp[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;  // position End
		for (int j = n - 2; j >= 0; j--) {
			dp[m - 1][j] = dp[m - 1][j + 1];  // last row
			handleObstacle(obstacleGrid, dp, m - 1, j);
		}
System.out.println(Arrays.toString(dp[m - 1]));
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = dp[i + 1][n - 1];  // last column
			handleObstacle(obstacleGrid, dp, i, n - 1);
		}
for (int k = 0; k < m; k++)
	System.out.println(dp[k][n - 1]);
		
		
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
				handleObstacle(obstacleGrid, dp, i, j);
			}
		}
		
		return dp[0][0];
	}

	private void handleObstacle(int[][] grid, int[][] dp, int x, int y) {
		if (grid[x][y] == 1) {
			dp[x][y] = 0;
		}
	}

	@Test
	public void test() {
		int[][] grid = {{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 1},
						{0, 1, 0, 0}};
		System.out.println(uniquePaths(grid));
	}
}
