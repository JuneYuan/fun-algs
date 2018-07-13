package leetcode1st.binarySearch;

public class P153FindMinimumInRotatedSortedArray {

    // 为什么使用A[hi]而非A[lo]作为判断条件？
    public int findMin(int[] A) {
        if (A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }

        int lo = 0, hi = A.length - 1;
        // case1: A[0] < A[hi]
        // case2: A[0] > A[hi] or A[0] < A[hi]
        while (lo + 1 < hi) {
            int md = lo + (hi - lo)/2;
            if (A[md] < A[hi]) {
                hi = md;
            } else {
                lo = md;
            }
        }

        return Math.min(A[lo], A[hi]);
    }
}
