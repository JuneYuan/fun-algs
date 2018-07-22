package leetcode1st.binarySearch;

public class P69Sqrtx {

    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }

        int lo = 1, hi = x;
        long md = 0;
        while (lo + 1 < hi) {
            md = lo + (hi - lo)/2;
            if (md * md == x) {
                return (int) md;
            } else if (md * md < x) {
                lo = (int) md;
            } else {
                hi = (int) md;
            }
        }

        return lo;
    }
}
