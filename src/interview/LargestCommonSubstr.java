package interview;

import java.util.Deque;
import java.util.LinkedList;

public class LargestCommonSubstr {
	private static Deque<Character> ret = new LinkedList<>();

	// 最长公共子序列问题
	public static int lcsLen(String A, String B) {
		int M = A.length(), N = B.length();
		// 结果数组和方向数组，下标从1起
		int[][] lcsLen = new int[M + 1][N + 1];
		int[][] lcsDir = new int[M + 1][N + 1];

		// 初始化0行0列
		for (int i = 0; i < M; i++)
			lcsLen[i][0] = 0;
		for (int i = 0; i < N; i++)
			lcsLen[0][i] = 0;

		// 公式实现
		for (int i = 1; i <= M; i++)
			for (int j = 1; j <= N; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					lcsLen[i][j] = 1 + lcsLen[i - 1][j - 1];
					lcsDir[i][j] = 0; // 左上
				} else {
					int x = lcsLen[i - 1][j], y = lcsLen[i][j - 1];
					if (x >= y) {
						lcsLen[i][j] = x;
						lcsDir[i][j] = 1; // 上边
					} else {
						lcsLen[i][j] = y;
						lcsDir[i][j] = 2; // 左边
					}
				}
			}
		
		// 求最长公共子序列的内容，k 用于计数，非必需
		for (int k = lcsLen[M][N], i = M, j = N; k > 0; ) {
			if (lcsDir[i][j] == 0) {
				ret.push(A.charAt(i-1));
				i--;  j--;  k--;
			} else if (lcsDir[i][j] == 1) {
				i--;
			} else {
				j--;
			}		
		}
		
		return lcsLen[M][N];
	}

	public static Iterable lcsText() {
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.printf("%d\n%s", lcsLen("ABCBDAB", "BDCABA"), ret);
	}
}
