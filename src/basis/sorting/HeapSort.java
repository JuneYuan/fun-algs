package basis.sorting;

import java.util.*;

public class HeapSort {

    public void sort(int[] A, boolean ascending) {
        if (ascending) {
            // build max heap
            heapify(A, A.length, -1);

            for (int i = A.length - 1; i >= 0; i--) {
                // take away the root
                swap(A, 0, i);
                // reconstruct max heap
                heapify(A, i, -1);
            }
        } else {
            heapify(A, A.length, 1);
            for (int i = A.length - 1; i >= 0; i--) {
                swap(A, 0, i);
                heapify(A, i, 1);
            }
        }
    }

    private void heapify(int[] A, int size, int sign) {
        for (int i = size / 2; i >= 0; i--) {
            sink(A, i, size, sign);
        }
    }

    private void sink(int[] A, int i, int sz, int sign) {
        int half = (sz >>> 1) - 1;
        while (i <= half) {
            int pos = i, lf = (i << 1) + 1, ri = lf + 1;
            // left leaf node search
            if (lf < sz && (sign * A[lf]) < (sign * A[pos])) {
                pos = lf;
            }
            // right leaf node search
            if (ri < sz && (sign * A[ri]) < (sign * A[pos])) {
                pos = ri;
            }

            // already heapify
            if (i == pos) {
                break;
            }

            // place A[i] correctly & adjust next index
            swap(A, i, pos);
            i = pos;
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{19, 1, 10, 14, 16, 4, 4, 7, 9, 3, 2, 8, 5, 11};
        new HeapSort().sort(A, true);
        System.out.println(Arrays.toString(A));
    }

}
