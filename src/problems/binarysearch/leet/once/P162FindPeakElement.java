package problems.binarysearch.leet.once;

public class P162FindPeakElement {

    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int md = lb + (ub - lb)/2;
            if (A[md] < A[md + 1]) {
                lb = md;
            } else if (A[md] < A[md - 1]) {
                ub = md;
            } else {
                return md;
            }
         }

         return A[lb] > A[ub] ? lb : ub;
    }
}
