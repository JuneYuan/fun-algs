package problems.binarysearch.lint.once;

public class P183WoodCut {

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }

        int lo = 0, hi = Integer.MIN_VALUE;
        // get the upper bound of L
        for (int h : L) {
            if (h > hi) {
                hi = h + 1;
            }
        }

        while (lo + 1 < hi) {
            int md = lo + (hi - lo)/2;
            if (feasible(L, k, md)) {
                lo = md;
            } else {
                hi = md;
            }
        }

        return lo;
    }

    private boolean feasible(int[] L, int k, int x) {
        int sum = 0;
        for (int h : L) {
            sum += h / x;
        }

        return sum >= k;
    }
}
