package problems.binarysearch.leet.once;

public class P34SearchForRange {

    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[]{-1, -1};

        if (A == null || A.length == 0) {
            return ret;
        }

        int st = -1,  ed = A.length;

        // lower bound
        while (st + 1 < ed) {
            int mid = st + (ed - st)/2;
            if (A[mid] < target) {
                st = mid;
            } else {
                ed = mid;
            }
        }

        if (st + 1 < A.length && A[st + 1] == target) {
            ret[0] = st + 1;
        } else {
            return ret;
        }

        // upper bound
        ed = A.length;
        while (st + 1 < ed) {
            int mid = st + (ed - st)/2;
            if (A[mid] > target) {
                ed = mid;
            } else {
                st = mid;
            }
        }
        ret[1] = ed - 1;

        return ret;
    }

}
