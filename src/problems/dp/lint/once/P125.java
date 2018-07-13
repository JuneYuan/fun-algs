package lintcode1st.dp;

public class P125 {

    public int backPackII(int m, int[] A, int V[]) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] size = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
        	size[i] = A[i - 1];
        	value[i] = V[i - 1];
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= size[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - size[i]] + value[i]);
                }
            }
        }
        
        return dp[n][m];
    }

}
