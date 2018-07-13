package problems.binarysearch.leet.twice;

public class P33SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int lo = 0, hi = A.length - 1;
        while (lo + 1 < hi) {
            int md = lo + (hi - lo)/2;
            if (A[md] == target) {
                return md;
            }
            if (A[md] > A[lo]) {
                // case1: interval [lo, md] is sorted
                if (A[lo] <= target && target <= A[md]) {
                    hi = md;
                } else {
                    lo = md;
                }
            } else {
                // case2: interval [md, hi] is sorted
                if (A[md] <= target && target <= A[hi]) {
                    lo = md;
                } else {
                    hi = md;
                }
            }
        }

        if (A[lo] == target) {
            return lo;
        } else if (A[hi] == target) {
            return hi;
        }
        return -1;
    }
}
