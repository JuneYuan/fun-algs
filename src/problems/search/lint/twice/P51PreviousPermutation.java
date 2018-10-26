package problems.search.lint.twice;

import java.util.ArrayList;
import java.util.List;

public class P51PreviousPermutation {

    public List<Integer> previousPermutation(List<Integer> A) {
        List<Integer> ret = new ArrayList<>();

        if (A == null || A.size() == 0)     return ret;

        // step1: search the first A[k] > A[k+1] backward
        int k = -1;
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                k = i;
                break;
            }
        }

        // if current rank is the smallest, reverse it to largest, return
        if (k == -1) {
            reverse(A, 0, A.size() - 1);
            return new ArrayList<>(A);
        }

        // step2: search the first A[k] > A[l] backward
        int l = A.size() - 1;
        while (l > k && A.get(l) >= A.get(k)) {
            l--;
        }

        // step3: swap A[k] with A[l]
        int tmp = A.get(k);
        A.set(k, A.get(l));
        A.set(l, tmp);

        // step4: reverse between k+1 and A.size-1
        reverse(A, k + 1, A.size() - 1);
        return new ArrayList<>(A);
    }

    private void reverse(List<Integer> A, int lb, int ub) {
        for (int i = lb, j = ub; i < j; i++, j--) {
            int tmp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, tmp);
        }
    }

}
