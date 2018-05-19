package exam;

import java.util.Arrays;
import java.util.Scanner;

/*
最大子区间和
输入数组长度N和数组A[]，它的前缀（即左起连续若干个数字）可以都乘以－1，后缀（即右边起连续的若干个数字）也可以都乘以－1，这样就得到新的序列，每个新的序列可求得最大子区间和，输出众多最大子区间和中最大的那一个。

> 样例：
6
-3 5 -2 6 8 -3
 */
public class YiDian1_maxSubarray {
	private static int N;
	private static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
        if (nums == null || nums.length == 0) {
        	System.out.println(0);
        }
        
        int result = helper(nums);
        // 前缀[0, L)，后缀(R, N - 1]
        for (int L = 0; L < N; L++) {
        	
/*        	nums[L] *= -1;
        	int t = helper(nums);
        	result = Math.max(result, t);
        	nums[L] *= -1;*/
        	
        	for (int R = N - 1; R >= L - 1; R--) {
        		int[] copyNums = change(nums, L, R);
        		int t = helper(copyNums);
// System.out.printf("L=%d, R=%d  ", L, R);
// System.out.println(Arrays.toString(copyNums) + " => " + t);        		
        		result = Math.max(result, t);
        	}
        }
        
		System.out.println(result);
		sc.close();
	}

	private static int helper(int[] A) {
		int sum = 0, result = Integer.MIN_VALUE;
        for (int num : A) {
        	sum += num;
        	result = Math.max(result, sum);	// update maxSub
        	sum = Math.max(sum, 0);		// drop negtive sum
        	    	
        }
        return result;
	}

	private static int[] change(int[] A, int L, int R) {
		int[] copyA = Arrays.copyOf(A, A.length);
		for (int i = 0; i < L; i++) {
			copyA[i] *= -1;
		}

		for (int i = copyA.length - 1; i > R; i--) {
			copyA[i] *= -1;
		}
		return copyA;
	}
}
