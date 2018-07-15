package problems.binarysearch.leet.once;

public class P4MedianOfTwoSortedArrays {

    /**
     * merge sort with equal length
     */
    public double solution1(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return -1.0;
        }

        int lenA = (A == null) ? 0 : A.length;
        int lenB = (B == null) ? 0 : B.length;
        int len = lenA + lenB;

        // merge sort
        int idxA = 0, idxB = 0, idxC = 0;
        int[] C = new int[len];
        // case1: both A and B have elements
        while (idxA < lenA && idxB < lenB) {
            if (A[idxA] < B[idxB]) {
                C[idxC++] = A[idxA++];
            } else {
                C[idxC++] = B[idxB++];
            }
        }
        // case2: only A has elements
        while (idxA < lenA) {
            C[idxC++] = A[idxA++];
        }
        // case3: only B has elements
        while (idxB < lenB) {
            C[idxC++] = B[idxB++];
        }

        // return median for even and odd cases
        if (len % 2 == 0) {
            return (C[len/2] + C[len/2 - 1]) / 2.0;
        } else {
            return C[len/2];
        }
    }
}
