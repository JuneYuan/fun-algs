package problems.array.leet.twice;

public class P215KthLargestElementInArray {

    public int findKthLargest(int[] A, int k) {
        if (A == null || A.length == 0) {
            return -1;
        }

        return qSort1(A, 0, A.length - 1, k);
    }

    /**
     * two-way partitioning
     */
    private int qSort(int[] A, int lo, int hi, int k) {
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
            return qSort(A, lo, j - 1, k);
        } else {
            return qSort(A, j + 1, hi, k);
        }
    }

    /**
     * one index for partition
     */
    private int qSort1(int[] A, int lo, int hi, int k) {
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
            return qSort1(A, lo, m - 1, k);
        } else {
            return qSort1(A, m + 1, hi, k);
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,5,6,4};
        int k = 3;
        int ans = new P215KthLargestElementInArray().findKthLargest(A, k);
        System.out.println(ans);
    }

}
