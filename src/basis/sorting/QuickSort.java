package basis.sorting;

public class QuickSort {

	public static void quickSort_inplace_twoIndex(int[] A, int L, int R) {
		for (int item : A) {
			System.out.println(item + " ");
		}
		System.out.println();
		
		if (L >= R)	return;
		
		int m = partition(A, L, R);

		// swap the smaller(j) with pivot
		int temp = A[m];
		A[m] = A[L];
		A[L] = temp;
		
		quickSort_inplace_twoIndex(A, L, m - 1);
		quickSort_inplace_twoIndex(A, m + 1, R);
	}
	
	private static int partition(int[] A, int L, int R) {	
		int pivot = A[L];
		int i = L + 1, j = R;
		while (i <= j) {
			while (i <= j && A[i] < pivot) {
				i++;
			}
			while (i <= j && A[j] >= pivot) {
				j--;
			}
			if (i > j)	break;
			
			// swap A[left] with A[right] while left <= right
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
		
		return j;
	}

	/* L, R: 待排序部分的左、右边界
	 * pivot: 基准元素，这里设为A[L]
	 * 下标m: 遍历到数组第i个元素时，当前partition的索引
	 */
	public static void quickSort_inplace_oneIndex(int[] A, int L, int R) {
		for (int item : A) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		// 递归终止条件
		if (L >= R)	return;

		int pivot = A[L];
		int m = L;
		for (int i = L + 1; i <= R; i++) {
			if (A[i] < pivot) {	// 这里只能用"<"
				m += 1;
				int temp = A[m];
				A[m] = A[i];
				A[i] = temp;
			}
		}
		// swap between A[m] and A[L]
		int temp = A[m];
		A[m] = A[L];
		A[L] = temp;
		
		quickSort_inplace_oneIndex(A, L, m - 1);
		quickSort_inplace_oneIndex(A, m + 1, R);
	}
	
	public static void main(String[] args) {
		int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
		quickSort_inplace_oneIndex(unsortedArray, 0, 7);
		System.out.println("After sort:");
		for (int item : unsortedArray) {
			System.out.print(item + " ");
		}
	}
}

