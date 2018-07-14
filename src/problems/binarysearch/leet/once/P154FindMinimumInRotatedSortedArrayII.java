下、package leetcode1st.binarySearch;

public class P154FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] A) {
        if (A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }

        // case1: A[0] < A[hi]
        // case2: A[0] > A[hi] or A[0] < A[hi]
        int lo = 0, hi = A.length - 1;
        while (lo + 1 < hi) {
            int md = lo + (hi - lo)/2;
            if (A[md] < A[hi]) {
                hi = md;
            } else if (A[md] > A[hi]) {
                lo = md;
            } else {
                // TODO 这是什么意思？
                hi--;
            }
        }

        return Math.min(A[lo], A[hi]);
    }
}
