package leetcode2nd;

public class P88MergeSortedArray {
	public void merge(int[] A, int m, int[] B, int n) {
        // corner case
        if (A == null || B == null)
            return;
        
        int index = m + n - 1;
        while (m > 0 || n > 0) {
            if (m == 0) {
                for (; n > 0; n--, index--) {
                    A[index] = B[n - 1];
                }
                break;
            }
            
            if (n == 0) {
                break;
            }
            
            if (A[m - 1] > B[n - 1]) {
                A[index] = A[m - 1];
                index--;
                m--;
            } else {
                A[index] = B[n - 1];
                index--;
                n--;
            }
        }

    }
}
