package exam;

import java.util.Scanner;

/* 
袋鼠过河（Jump跳跃问题）
袋鼠要从河这岸跳到河那岸，河中间每隔一米打了一个桩子，桩子上设有弹簧，弹簧有对应的力量值。通过弹簧i最远可跳到Ai远处，若Ai = 0，则陷进去无法继续跳跃。河流宽N米，袋鼠初始位置在第一个弹簧上面，跳到最后一个弹簧就算过河了。

输入：数组长度N，和每一项的值（代表该弹簧所能提供的弹跳距离）
输出：求从初始弹簧跳到对岸的最少跳数，若无法到达则输出－1

样例：
5 
2 0 1 1 1 =>4
 */
public class Sohu2_mouseJump {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int result = Integer.MAX_VALUE;
		int[] dp = new int[N];
		// init
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		// process
		for (int i = 0; i < N; i++) {
			if (A[i] == 0) {
				result = -1;
				break;
			}
			if (A[i] != 0) {
				int idx = i + A[i];
				if (i + A[i] < N) {
					dp[idx] = Math.min(dp[idx], dp[i] + 1);
				}
			}
		}
		// conclusion
		if (result == -1) {
			System.out.println(result);
			return;
		}
		result = dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N -1];
		System.out.println(result);
	
		
		
		sc.close();
	}
}
