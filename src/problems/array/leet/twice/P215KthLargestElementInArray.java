package problems.array.leet.twice;

import java.util.Arrays;

public class P215KthLargestElementInArray {

    /**
     * 迭代
     */
    public int mySolutin(int[] A, int k) {
        if (A == null || A.length == 0 || k < 0 || k > A.length) {
            return -1;
        }

        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int idx = partition(A, lo, hi);
            if (idx == k - 1) {
                return A[idx];
            } else if (idx < k - 1) {
                lo = idx + 1;
            } else {
                hi = idx - 1;
            }
        }

        return -1;
    }

    private int partition(int[] A, int lo, int hi) {
        int pivot = A[lo], i = lo + 1, j = hi;
        while (i <= j) {
            while (i <= j && A[i] > pivot) {
                i++;
            }
            while (i <= j && A[j] <= pivot) {
                j--;
            }
            if (i < j) {
                swap(A, i, j);
            }
        }
        swap(A, lo, j);

        return j;
    }

    /**
     * 递归
     */
    public int refSolution(int[] A, int k) {
        if (A == null || A.length == 0) {
            return -1;
        }

        return refSolution1(A, 0, A.length - 1, k);
//        return refSolution2(A, 0, A.length - 1, k);
    }

    /**
     * two-way partitioning
     */
    private int refSolution1(int[] A, int lo, int hi, int k) {
        if (lo >= hi) {
            return A[hi];
        }

        // find location of A[lo] after partition
        int pivot = A[lo], i = lo + 1, j = hi;
        while (i <= j) {
            while (i <= j && A[i] >= pivot) {
                i++;
            }
            while (i <= j && A[j] < pivot) {
                j--;
            }
            if (i < j) {
                swap(A, i, j);
            }
        }
        swap(A, lo, j);

        if (j + 1 == k) {
            return A[j];
        } else if (j + 1 > k) {
            return refSolution1(A, lo, j - 1, k);
        } else {
            return refSolution1(A, j + 1, hi, k);
        }
    }

    /**
     * one index for partition
     */
    private int refSolution2(int[] A, int lo, int hi, int k) {
        // lo should not be greater than hi
        if (lo >= hi) {
            return A[hi];
        }

        // index m of A
        int m = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (A[i] > A[lo]) {
                swap(A, ++m, i);
            }
        }
        swap(A, lo, m);

        if (m + 1 == k) {
            return A[m];
        } else if (m + 1 > k) {
            return refSolution2(A, lo, m - 1, k);
        } else {
            return refSolution2(A, m + 1, hi, k);
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,5,6,4};
//        int[] A = new int[]{-1,2,0};
        for (int k = 2; k <= A.length; k++) {
            int ans = new P215KthLargestElementInArray().mySolutin(Arrays.copyOf(A, A.length), k);
            System.out.printf("k=%d, ans=%d\n", k, ans);
        }
    }

}
