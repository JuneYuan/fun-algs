package basis.algorithm;

import java.util.Scanner;

// POJ 1064
public class BinarySearch2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		double[] nums = new double[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextDouble();
		}
		System.out.printf("%.2f\n", Math.floor(solve(nums, k) * 100) / 100 );
		
		in.close();
	}
	
	private static double solve(double[] nums, int K) {
		double lb = 0.00, ub = 10e5 + 0.01;
		// 对于double类型，可以使用计数循环来避免精度处理上的麻烦
		// while (lb + 0.001 < ub) {
		for (int i = 0; i < 100; i++) {
			double mid = lb + (ub - lb) / 2;
			if (C(nums, mid, K)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}
		
		return lb;
	}

	// 判断给定数组num[]能否切割出K条长度均为seg的绳子
	private static boolean C(double[] nums, double seg, int k) {
		int count = 0;
		for (double num : nums) {
			count += Math.floor(num / seg);
		}
		
		return count >= k;
	}
}
