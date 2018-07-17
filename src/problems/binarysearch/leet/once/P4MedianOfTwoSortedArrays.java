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
        int[] C = new int[len];
        int idxA = 0, idxB = 0, idxC = 0;
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

    /**
     * space optimization
     */
    public double solution2(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return -1.0;
        }

        int lenA = (A == null) ? 0 : A.length;
        int lenB = (B == null) ? 0 : B.length;
        int len = lenA + lenB;
        int m1 = 0, m2 = 0;

        // merge sort
        int idxA = 0, idxB = 0, idxC = 0;
        while (idxA < lenA && idxB < lenB) {
            if (idxC > (len/2)) {
                break;
            }
            if (idxC == (len/2 - 1)) {
                m1 = Math.min(A[idxA], B[idxB]);
            }
            if (idxC == (len/2)) {
                m2 = Math.min(A[idxA], B[idxB]);
            }
            if (A[idxA] < B[idxB]) {
                idxA++;
            } else {
                idxB++;
            }
            idxC++;
        }

        while (idxA < lenA) {
            if (idxC > (len/2)) {
                break;
            }
            if (idxC == (len/2 - 1)) {
                m1 = A[idxA];
            }
            if (idxC == (len/2)) {
                m2 = A[idxA];
            }
            idxA++;
            idxC++;
        }

        while (idxB < lenB) {
            if (idxC > (len/2)) {
                break;
            }
            if (idxC == (len/2 - 1)) {
                m1 = B[idxB];
            }
            if (idxC == len/2) {
                m2 = B[idxB];
            }
            idxB++;
            idxC++;
        }

        if (len % 2 == 0) {
            return (m1 + m2)/2.0;
        } else {
            return m2;
        }
    }

    /**
     * binarysearch
     */
     public double solution3(int[] A, int[] B) {
         if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
             return -1.0;
         }

         int lenA = (A == null) ? 0 : A.length;
         int lenB = (B == null) ? 0 : B.length;
         int len = lenA + lenB;

         // return median for even and odd cases
         if (len % 2 == 0) {
             return (findKth(A, 0, B, 0, len/2) + findKth(A, 0, B, 0, len/2 + 1)) / 2.0;
         } else {
             return findKth(A, 0, B, 0, len/2 + 1);
         }
     }

     private int findKth(int[] A, int idxA, int[] B, int idxB, int k) {
         int lenA = (A == null) ? 0 : A.length;
         if (idxA > lenA - 1) {
             return B[idxB + k - 1];
         }
         int lenB = (B == null) ? 0 : B.length;
         if (idxB > lenB - 1) {
             return A[idxA + k - 1];
         }

         // avoid infinite loop if k == 1
         if (k == 1) {
             return Math.min(A[idxA], B[idxB]);
         }

         int keyA = Integer.MAX_VALUE, keyB = Integer.MAX_VALUE;
         if (idxA + k/2 - 1 < lenA) {
             keyA = A[idxA + k/2 - 1];
         }
         if (idxB + k/2 - 1 < lenB) {
             keyB = B[idxB + k/2 - 1];
         }

         if (keyA > keyB) {
             return findKth(A, idxA, B, idxB + k/2, k - k/2);
         } else {
             return findKth(A, idxA + k/2, B, idxB, k - k/2);
         }
     }

}
