package lintcode1st.dp;

import org.junit.Test;

public class P92 {

    public int backPack(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        
        return dp[n][m];
    }

    @Test
    public void test() {
    	int m = 10;
    	int[] A = {3, 4, 8, 5};
    	System.out.println(backPack(m, A));
    }
}
