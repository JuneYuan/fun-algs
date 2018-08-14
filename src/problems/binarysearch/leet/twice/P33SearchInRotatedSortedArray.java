package problems.binarysearch.leet.twice;

import java.util.*;

public class P33SearchInRotatedSortedArray {

    /**
     * solution1
     */
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

    /**
     * solution2
     */
    public int solution2(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int p = findBreakPoint(A);
        if (target >= A[0]) {
            // search in [lo, segPoint]
            return binSearch(A, target, 0, p);
        } else {
            // search in [segPoint, hi]
            return binSearch(A, target, p, A.length - 1);
        }
    }

    private int findBreakPoint(int[] A) {
        // A[index] < A[0], min[index]
        int index;

        int lo = 0, hi = A.length - 1, segValue = A[0];
        while (lo + 1 < hi) {
            int md = lo + (hi - lo)/2;
            if (A[md] > segValue) {
                lo = md;
            } else {
                hi = md;
            }
        }
        index = A[lo] < segValue ? lo : hi;

        return index;
    }

    private int binSearch(int[] A, int target, int lo, int hi) {
        while (lo + 1 < hi) {
            int md = lo + (hi - lo) / 2;
            if (A[md] == target) {
                lo = md;
            } else if (A[md] < target) {
                lo = md;
            } else {
                hi = md;
            }
        }

        if (A[lo] == target) {
            return lo;
        }
        if (A[hi] == target) {
            return hi;
        }
        return -1;
    }

    /**
     * solution2b
     */
    interface Fun {

        boolean f(int a, int b);
    }

    /**
     * fffffttttt => get last f
     */
    public static int bin(int[] a, int target, Fun f) {
        int l = 0, r = a.length - 1, m = (l + r) >> 1;
        int ans = r + 1;
        while (l <= r) {
            if (!f.f(a[m], target)) { // should go right
                l = m + 1;
                ans = m;
            } else { // left
                r = m - 1;
            }
            m = (l + r) >>1;
        }
        return ans;
    }

    public static int solove(int[] a, int target) {
        // get last index which a[index] >= a[0]
        int lf = bin(a, a[0], (x, y) -> x < y);
        if (lf >= a.length) { // if not exist return -1
            return -1;
        }
        int ans = -1;
        if (target < a[0]) { // ans should in [lf + 1, r]
            // get last index which a[index] <= target
            int t = bin(Arrays.copyOfRange(a, lf + 1, a.length), target,
                    (x, y) -> x > y) + lf + 1;
            if (t < a.length && a[t] == target) {
                ans = t;
            }
        } else { // ans should in [l, lf]
            // get last index which a[index] <= target
            int t = bin(Arrays.copyOfRange(a, 0, lf + 1), target,
                    (x, y) -> x > y);
            if (t <= lf && a[t] == target) {
                ans = t;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 1, 2, 3};
        int target = 3;
        System.out.println(solove(A, target));
    }

}
