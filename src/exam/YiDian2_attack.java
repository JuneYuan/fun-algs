package exam;

import java.util.Scanner;

/*
丧尸攻击
N个丧尸围成一圈攻击玩家，伤害力由数组A[]给出。玩家每次可击毙连续的3个丧尸（不足3个时按实际个数算），同时会收到其余丧尸的群起攻击。问玩家受到最小伤害值为多少？

输入：N和A[]
输出：最小伤害值

> 样例：
7
3 4 2 2 1 4 1
 */
public class YiDian2_attack {
	private static int N;
	private static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}		
		
		int sum = 0;
        do {
        	A = rmMxClose3(A);
        	for (int a : A) {
        		sum += a;
        	}
        } while (A.length > 0);

		System.out.println(sum);
		sc.close();
	}

	private static int[] rmMxClose3(int[] A) {
		int N = A.length;
		if (N <= 3) {
			return new int[0];
		}
		
		int[] result = new int[N - 3];
		int[] B = new int[N + 2];
		
		// B = A + A[0] + A[1]
		System.arraycopy(A, 0, B, 0, N);
		B[N] = A[0];
		B[N + 1] = A[1];

		// find max close three, in interval [L, R]
		int mxClose3Sum = Integer.MIN_VALUE, L = 0, R = 2;
		for (int i = 0; i < N; i++) {
			int tmp = B[i] + B[i + 1] + B[i + 2];
			if (tmp > mxClose3Sum) {
				mxClose3Sum = tmp;
				L = i;
				R = i + 2;
			}
		}
		// result = B - [L, R] 
		System.arraycopy(B, 0, result, 0, L);
		System.arraycopy(B, R + 1, result, L, N - 1 - R);
		
		return result;
	}
}
