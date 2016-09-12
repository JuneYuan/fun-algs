package basis.algorithm;

public class BinarySearch {

	// CORE: A[idx] >= target, min(idx)???
	private static int lowerBound(int[] A, int target) {
		if (A == null || A.length == 0)		return -1;
		int lb = -1, ub = A.length;
		while (lb + 1 < ub) {
			int mid = lb + (ub - lb) / 2;
			if (A[mid] < target) {
				lb = mid;
			} else {
				ub = mid;
			}
		}
		
		return lb + 1;
	}
	
	// CORE: A[idx] <= target, max(idx)???
	private static int upperBound(int[] A, int target) {
		if (A == null || A.length == 0)		return -1;
		int lb = -1, ub = A.length;
		while (lb + 1 < ub) {
			int mid = lb + (lb + ub) / 2;
			if (A[mid] > target) {
				ub = mid;
			} else {
				lb = mid;
			}
		}
		
		return ub - 1;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{1, 2, 2, 3, 4, 6, 6, 6, 13, 18};
		System.out.println(lowerBound(A, 6));	// 5
		System.out.println(upperBound(A, 6));	// 7
		
		System.out.println(lowerBound(A, 7));	// 8
		System.out.println(upperBound(A, 7));	// 7
	}
}
