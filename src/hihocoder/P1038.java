import java.util.Scanner;

public class P1038 {
	private static int N, M;
	private static int[] need, value;
	
	private static int ans;

	private static int f_1M() {
		int[] f = new int[M+1];
		for (int j = 0; j <= M; j++)
			f[j] = 0;
		for (int i = 1; i <= N; i++)
			for (int j = M; j >= need[i]; j--)
				f[j] = Math.max(f[j], f[j-need[i]] + value[i]);
		return f[M];
	}
	
	private static int f_2M() {
		int[] f0 = new int[M+1];
		int[] f1 = new int[M+1];
		for (int j = 0; j <= M; j++)
			f0[j] = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 0; j <= M; j++) {
				if (i % 2 == 1)
					if (j <= need[i])
						f1[j] = f0[j];
					else					
						f1[j] = Math.max(f0[j], f0[j-need[i]] + value[i]);
				else
					if (j <= need[i])
						f0[j] = f1[j];
					else					
						f0[j] = Math.max(f1[j], f1[j-need[i]] + value[i]);
					
			}
		return Math.max(f0[M], f1[M]);
	}
	
	private static int f_NM() {
		int[][] f = new int[N+1][M+1];
		for (int j = 0; j <= M; j++)
			f[0][j] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (j <= need[i])
					f[i][j] = f[i-1][j];
				else {
					int a = f[i-1][j];
					int b = f[i-1][j - need[i]] + value[i];
					f[i][j] = Math.max(a, b);
				}
			}
		}
		return f[N][M];
	}
	
/*	public static void dfs(double c, int v, int dep) {
		if (dep >= N) {
			ans = Math.max(ans, v);
			return;
		}
		
		dfs(c + need[dep], v + value[dep], dep + 1);
		
		
		if (dep >= N) {
			if ((int) (2 * c) % 10 == 0)
				ans = Math.max(ans, v);
			return;
			
		}
		if (cnt < 3)
			dfs(c + cost[dep], v + value[dep], dep + 1, cnt + 1);
		dfs(c, v, dep + 1, cnt);
		
	}

*/	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 物品数
		M = sc.nextInt();  // 奖券数（背包体积）
		need = new int[N+1];
		value = new int[N+1];
		for (int i = 1; i <= N; i++) 
		{ need[i] = sc.nextInt();	value[i] = sc.nextInt(); }
		

		System.out.println(f_1M());
		
		sc.close();

	}

}
