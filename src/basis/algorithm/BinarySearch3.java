package basis.algorithm;

public class BinarySearch3 {
	public int binarySearch(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				start = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		
		return -1;
	}
	
}
