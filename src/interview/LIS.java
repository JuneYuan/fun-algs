package interview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

//最长递增子序列问题
public class LIS {
	
	// 转化为A[]与sorted A[]的最长公共子序列
	public static void lcs(int[] A, int[] B) {
		int M = A.length, N = B.length;
		// 结果数组和方向数组，下标从1起
		int[][] dpLen = new int[M+1][N+1];
		int[][] dpDir = new int[M+1][N+1];
		Deque<Integer> ret = new LinkedList<>();
		
		// 根据DP公式填充结果数组dpLen[]和方向数组dpDir
		for (int i = 0; i <= M; i++)	dpLen[i][0] = 0;
		for (int j = 0; j <= N; j++)	dpLen[0][j] = 0;
		
		for (int i = 1; i <= M; i++) {
			for (int j =1; j <= N; j++) {
				if (A[i-1] == B[j-1]) {
					dpLen[i][j] = 1 + dpLen[i-1][j-1];
					dpDir[i][j] = 0;  // 左上
				} else {
					int x = dpLen[i-1][j], y = dpLen[i][j-1];
					if (x >= y) {
						dpLen[i][j] = x;
						dpDir[i][j] = 1;  // 上
					} else {
						dpLen[i][j] = y;
						dpDir[i][j] = 2;  // 左
					}
				}
			}
		}
		
		// 求最长公共子序列的内容
		// 从dpLen[M][N]出发，沿着dpDir记录的方向往回找，用栈记录结果
		for (int k = dpLen[M][N], i = M, j = N; k > 0; ) {
			if (dpDir[i][j] == 0) {
				ret.push(A[i-1]);
				i--;  j--;  k--;
			} else if (dpDir[i][j] == 1) 
				i--;
			else
				j--;
		}
		
		// 输出结果
		System.out.println(dpLen[M][N]);
		while (!ret.isEmpty()) {
			if (ret.size() < dpLen[M][N])
				System.out.print(" ");
			System.out.print(ret.pop());
		}
		System.out.println();
	}
	
	// dp[i]表示以a[i]结尾的最大递增子序列长度
	public static void dpN2(int[] A) {
		int N = A.length;
		int[] dp = new int[N];
		int[] B = new int[N];  // 辅助变量，记录每一个dp[i]是从哪一步转移过来的,便于找到确定递增子序列的内容
		Deque<Integer> ret = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int mx = 0;
			B[i] = -1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && dp[j] >= mx) {
					if (dp[j] > mx || (dp[j] == mx && A[j] < A[B[i]])) {
						mx = dp[j];
						B[i] = j;
					}
				}					
			}						
			dp[i] = mx + 1;
		}
		
		System.out.println(Arrays.toString(dp));
		
		// 求LIS的内容
		int k = idxOfLargest(A);
		ret.push(A[k]);
		while (B[k] != -1) {
			ret.push(A[B[k]]);
			k = B[k];
		}
		System.out.println(Arrays.toString(B));
		System.out.println(ret);

	}
	private static int idxOfLargest(int[] a) {
		int mx = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] > a[mx])	mx = i;
		return mx;
	}
	
	// dp[i]表示长度为i的LIS末尾元素最小值
	public static void dpNlogN(int[] A) {
		int N = A.length;
		int mxl = 0;
		int[] dp = new int[N+1];
		int[] f = new int[N];		//  f[i]: 以a[i]结尾的LIS最大长度
		Deque<Integer> ret = new LinkedList<>();
		
		dp[1] = A[0];
		for (int i = 1; i < N; i++) {
			int pos = upper_bound(dp, 1, mxl, A[i]);
			dp[pos] = A[i];
			f[i] = pos;
			if (mxl < pos)
				mxl = pos;
		}		
		System.out.println(Arrays.toString(f));

		// 结合A[]和f[]来求LIS的内容
		int i = N - 1;
		int x = mxl;
		while (f[i] != mxl)	
			i--;
		ret.push(A[i]);		// 第mxl大元素
		while (i > 0 && x >= 1) {
			if (f[--i] == x-1) {
				if (A[i] < ret.peek()) {
					ret.push(A[i]);		// 第mxl－1 .. 1大元素
					x--;
				}
			}
		}
		System.out.println(ret);
	}
	private static int upper_bound(int[] dp, int l, int r, int key) {
		// dp[]数组为空时，key直接插入在第一个位置；若
		if (dp.length == 0)
			return 1;
		if (dp[r] <= key)
			return r + 1;
		int mid;
		while (l < r) {
			mid = (l + r) / 2;
			if (dp[mid] <= key)
				l = mid + 1;
			else 
				r = mid;
		}
		return l;
	}

	
	@Test
	public void testLIS() {
		LIS.dpNlogN(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});
	}
	
	


	public static void main(String[] args) {
		
		dpN2(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});
		
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] a = line.split(" ");
				int[] A = new int[a.length];
				for (int i = 0; i < a.length; i++)
					A[i] = Integer.parseInt(a[i]);
				
				dpN2(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});

/*				int[] B = A.clone();
				Arrays.sort(B);
				lcs(A, B);*/
			}
		}
		
	}
}
