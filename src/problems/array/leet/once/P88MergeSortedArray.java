package leetcode1st.array;

import java.util.Arrays;
import java.util.Collections;

public class P88MergeSortedArray {

     public void mergeSortedArray(int[] A, int m, int[] B, int n) {
         if (A == null || B == null) {
             throw new IllegalStateException();
         }

         int index = m + n - 1;
         while (m > 0 && n > 0) {
             if (A[m - 1] > B[n - 1]) {
                 A[index] = A[--m];
             } else {
                 A[index] = A[--n];
             }
             index--;
         }

         // 如果m不晚于n到达0，那么B[]有剩余，需继续填充到A[]中
         // 如果m晚于n到达0，那么A[]有剩余，不必再处理
         while (n > 0) {
             A[index] = B[--n];
             index--;
         }
     }

    /**
     * lintcode P6
     */
     public int[] noneInPlaceSln(int[] A, int[] B) {
         if (A == null || A.length == 0) {
             return B;
         }
         if (B == null || B.length == 0) {
             return A;
         }

         int szA = A.length, szB = B.length;
         int[] C = new int[szA + szB];
         int index = 0, i = 0, j = 0;
         while (i < szA && j < szB) {
             if (A[i] < B[j]) {
                 C[index++] = A[i++];
             } else {
                 C[index++] = B[j++];
             }
         }

         // A有剩余
         while (i < szA) {
             C[index++] = A[i++];
         }

         // B有剩余
         while (j < szB) {
             C[index++] = B[j++];
         }

         return C;
     }

}
