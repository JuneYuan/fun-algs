package exam;

import java.util.Scanner;

public class Didi1_maxSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
        if (nums == null || nums.length == 0) {
        	System.out.println(0);
        }
        
        int sum = 0, result = Integer.MIN_VALUE;
        for (int num : nums) {
        	sum += num;
        	result = Math.max(result, sum);	// update maxSub
        	sum = Math.max(sum, 0);		// drop negtive sum
        	    	
        }
        
		System.out.println(result);
		sc.close();
	}
}
