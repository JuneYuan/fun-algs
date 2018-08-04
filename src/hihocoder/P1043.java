package hihocoder;

import java.util.Scanner;

public class P1043 {
	private static int N, M;
	private static int[] need, value;
	
	// 相当于0～1背包公式扩展到了0～k背包
	private static int f_NMK() {
		int[][] dp = new int[N+1][M+1];
		for (int j = 0; j <= M; j++)
			dp[0][j] = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++) {
				int K = M / need[i];
				int temp = 0;
				for (int k = 0; k <= K; k++) {
					if (j >= need[i]*k) {
						temp = Math.max(temp, dp[i-1][j-need[i]*k] + value[i]*k);
						dp[i][j] = temp;						
					} else 
						dp[i][j] = dp[i-1][j];
				}
			}
		return dp[N][M];
	}
	
	// 优化状态转移方程
	private static int f_NM() {
		int[][] dp = new int[N+1][M+1];
		for (int j = 0; j <= M; j++)
			dp[0][j] = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++) {
				if (j >= need[i])
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-need[i]] + value[i]);
				else 
					dp[i][j] = dp[i-1][j];
			}
		return dp[N][M];
	}
	
	// 优化空间复杂度
	private static int f_1M() {
		int[] dp = new int[M+1];
		for (int j = 0; j <= M; j++)
			dp[j] = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++) {
				if (j >= need[i])
					dp[j] = Math.max(dp[j], dp[j-need[i]] + value[i]);
			}
		return dp[M];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 物品数
		M = sc.nextInt();  // 奖券数（背包体积）
		need = new int[N+1];
		value = new int[N+1];
		for (int i = 1; i <= N; i++) 
		{ need[i] = sc.nextInt();	value[i] = sc.nextInt(); }
		
		System.out.println(f_1M());
		//System.out.println(f_NM());
		//System.out.println(f_NMK());
		
		sc.close();

	}

}
