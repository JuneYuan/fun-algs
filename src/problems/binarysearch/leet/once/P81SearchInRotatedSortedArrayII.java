package leetcode1st.binarySearch;

public class P81SearchInRotatedSortedArrayII {

	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		int lo = 0, hi = A.length -1;
		while (lo + 1 < hi) {
			int md = lo + (hi - lo)/2;
			if (A[md] == target) {
				return true;
			}
			if (A[md] > A[lo]) {
				// case1: interval [lo, md] is sorted
				if (A[lo] <= target && target <= A[md]) {
					hi = md;
				} else {
					lo = md;
				}
			} else if (A[md] < A[hi]) {
				// case2: interval [md, hi] is sorted
				if (A[md] <= target && target <= A[hi]) {
					lo = md;
				} else {
					hi = md;
				}
			} else {
				// case 3: A[md] == target
				lo++;
			}
		}

		if (target == A[lo] || target == A[hi]) {
			return true;
		}
		return false;
	}

}
