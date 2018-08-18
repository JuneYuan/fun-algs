package basis.datastruct;

import java.util.*;

public class Heapify {

    public void heapify(int[] A) {
        heapify(A, A.length);
    }

    private void heapify(int[] A, int sz) {
        for (int i = sz / 2; i >= 0; i--) {
            sink(A, i, sz);
        }
    }

    private void sink(int[] A, int i, int sz) {
        int hf = sz / 2 - 1;
        while (i <= hf) {
            int pos = i, lf = (i << 1) +1, ri = lf + 1;
            if (lf < sz && A[lf] < A[pos]) {
                pos = lf;
            }
            if (ri < sz && A[ri] < A[pos]) {
                pos = ri;
            }

            if (pos == i) {
                break;
            }
            swap(A, i, pos);
            i = pos;
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
        new Heapify().heapify(A);
        System.out.println(Arrays.toString(A));
    }

}
