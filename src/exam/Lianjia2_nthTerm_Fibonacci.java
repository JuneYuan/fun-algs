package exam;

import java.util.Scanner;

/* 求序列 A, B, BA, BAB, BABBA, ... 第n项中"A"、"B"各有几个？
 * 规则：前一项的所有"B"->"BA", 所有"A"->"B"
 * 规律：A[n] = A[n - 1] + A[n - 2], 其中"+"号代表字符串拼接
 * 进阶规律：斐波那契序列。由于只输出A、B个数，不要求输出内容，那么每一项中，对A、B分别应用Fibonacci规律即可
 */

// Fibonacci 解法
public class Lianjia2_nthTerm_Fibonacci {
	public static void main(String[] args) {
		int[][] ans = helper();		
		
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		int b = ans[K][1];
		int a = ans[K][0];

		System.out.println(a + " " + b);
		sc.close();
	}		  

	private static int[][] helper() {
		int[][] result = new int[46][2];
		
		result[0][0] = 1;  result[0][1] = 0;
		result[1][0] = 0;  result[1][1] = 1;
		for (int i = 2; i < result.length; i++) {
			result[i][0] = result[i - 1][0] + result[i - 2][0];
			result[i][1] = result[i - 1][1] + result[i - 2][1];
		}
		
		return result;
	}
	

}
