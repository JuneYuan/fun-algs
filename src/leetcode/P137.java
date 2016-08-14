package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class P137 {

    public int singleNumber_1(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        
        int result = 0, sumBitI;
        for (int i = 0; i < Integer.SIZE; i++) {
            sumBitI = 0; 
            for (int j = 0; j < nums.length; j++) {
                // get {i}th bit of nums[j]
                sumBitI += (nums[j] >> i) & 1;
            }
            // set {i}th bit of result
            result |= (sumBitI % 3) << i;
        }
        
        return result;
    }

    public int singleNumber_DP(int[] A) {
    	int k = 3, l = 1;
        if (A == null) return 0;
        int t;
        int[] x = new int[k];
        x[0] = ~0;
System.out.println("A = " + Arrays.toString(A));        
System.out.println("x = " + Arrays.toString(x));
        for (int i = 0; i < A.length; i++) {
            t = x[k-1];
            for (int j = k-1; j > 0; j--) {
                x[j] = (x[j-1] & A[i]) | (x[j] & ~A[i]);
System.out.printf("x[%d] = (x[%d] & A[%d]) | (x[%d] & ~A[%d]) = %s | %s = %d\n", 
					j, j-1, i, j, i, 
					Integer.toBinaryString(x[j-1] & A[i]), 
					Integer.toBinaryString(x[j] & ~A[i]), x[j]);
            }
            x[0] = (t & A[i]) | (x[0] & ~A[i]);
System.out.printf("x[0] = (x[%d-1] & A[%d]) | (x[0] & ~A[%d]) = %s | %s = %d\n", 
					k, i, i,
					Integer.toBinaryString(t & A[i]), 
					Integer.toBinaryString(x[0] & ~A[i]), x[0]);            
System.out.printf("第%d次循环后，x = %s\n", i+1, Arrays.toString(x));            
        }
        return x[l];
    }

    @Test
    public void test() {
    	int[] A = {10, 5, 8, 10, 5, 5, 10};
    	int ans = singleNumber_2(A);
    	System.out.println(ans);
    }
}
