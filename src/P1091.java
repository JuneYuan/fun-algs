import java.util.Scanner;

public class P1091 {

	private static int N, M;	// # of heros and coins
	private static int[] benefit, expense, maxLevel;  // info of EACH hero
	private static int[][] f;	// recursive records
	private static int ret;		// optimal solution
	
	public static void clicker(Scanner scanner) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		maxLevel = new int[N + 1];
		maxLevel[0] = (int) (Math.log(M) / Math.log(1.07));
		
		benefit = new int[N + 1];
		expense = new int[N + 1];
		f = new int[N + 1][M + 1];
		
		process(scanner);		
		getResult();		
	}

	private static void process(Scanner scanner) {
		// 边界条件：f[0][0..M] = 0
		for (int v = 0; v <= M; v++)
			f[0][v] = 0;
		
		// 递归过程：英雄 1..N
		for (int i = 1; i <= N; i++) {
			benefit[i] = scanner.nextInt();
			expense[i] = scanner.nextInt();
			
			double numerator = 1 + M * 0.07 / expense[i] / 1.07;
			maxLevel[i] = (int) (Math.log(numerator) / Math.log(1.07));
				
			// 递归过程：使用的金币数 1..M
			for (int v = expense[i], add = v, w = 0; 
					v - add < M; w = v, v += add) {

				if (v > M)    v = M;								
				for (int j = v - 1; j > w; j--) 
					f[i][j] = f[i][v - add];
				
				// 递归过程：第 i 个英雄升级的次数 0..maxLevel[i]
				f[i][v] = f[i - 1][v];  // 不升级
				for (int lev = 1, exps = expense[i], bene = benefit[i], t; 
						lev <= maxLevel[i]; 
						lev++, exps += (int) (expense[i] * Math.pow(1.07, lev - 1)), bene += benefit[i]) {  // 英雄所提升的等级，可任选
					
					if (v >= exps) {						
						t = f[i - 1][v - exps] + bene;
						if (t > f[i][v])	f[i][v] = t;
					}
				}			
				
				add *= 1.07;
			}
		}
	}
	
	private static void getResult() {
		for (int i = 1; i <= M; i++) {
			if (f[N][i] > ret)
				ret = f[N][i];
		}
		System.out.println(ret);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		clicker(scanner);
		
		scanner.close();		
	}


}
