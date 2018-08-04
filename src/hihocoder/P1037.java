package hihocoder;

import java.util.Scanner;

public class P1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] a = new int[N][];
		for (int i = 0; i < N; i++)	{
			a[i] = new int[i + 1];
			for (int j = 0; j <= i; j++)
				a[i][j] = sc.nextInt();
		}
			
		// 处理
		int ans = a[0][0];
		int[][] f = new int[N][];
		for(int i = 0; i < N; i++)
			f[i] = new int[i + 1];
		
		f[0][0] = a[0][0];
		for (int i = 1; i < f.length; i++) {
			for (int j = 0; j < f[i].length; j++) {
				// 每行首元素
				if (j == 0)
					f[i][j] = a[i][j] + f[i-1][j];				
				// 每行尾元素
				else if (j == i) 
					f[i][j] = a[i][j] + f[i-1][j-1];
				// 中间元素
				else
					f[i][j] = a[i][j] + Math.max(f[i-1][j], f[i-1][j-1]);
				
				if (i == N-1 && f[i][j] > ans)
					ans = f[i][j];
			}
		}
		System.out.println(ans);
		
		sc.close();

	}

}
