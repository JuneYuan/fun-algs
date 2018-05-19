package basis.sorting;

public class QuickSort {

	public static void quickSort_inplace(int[] A, int L, int R) {		
		// 递归终止条件（少于两个元素时就退出了）
		if (R <= L)	return;
		
		// 分区，然后分治
		int m = partition1(A, L, R);	// 快慢指针
		// int m = partition2(A, L, R);	// 首尾指针
		quickSort_inplace(A, L, m - 1);
		quickSort_inplace(A, m + 1, R);
	}
	
	/* 首尾指针
	 * L, R: 待分区部分的左、右边界
	 * pivot: 基准元素，这里设为A[L]
	 * i: 从左向右扫描，遇到 !< pivot的元素时暂停，准备与某<pivot的元素交换
	 * j: 从右向左扫描，遇到 !>= pivot的元素时暂停，准备与某 >= pivot的元素交换
	 */
	private static int partition2(int[] A, int L, int R) {	
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
			swap(A, i, j);
		}
		
		// swap the smaller(j) with pivot
		swap(A, j, L);
		
		return j;
	}

	/* 快慢指针
	 * L, R: 待分区部分的左、右边界
	 * pivot: 基准元素，这里设为A[L]
	 * i: 遍历到数组第i个元素
	 * m: 遍历到数组第i个元素时，当前partition的索引，作用相当于一个计数器
	 */
	private static int partition1(int[] A, int L, int R) {
		int pivot = A[L];
		int m = L, i = L + 1;
		for (; i <= R; i++) {
			if (A[i] < pivot) {
				m++;
				swap(A, m, i);	// 遍历过程中把比pivot小的元素不断前移
			}
		}
		
		swap(A, L, m);	// 把pivot放到合适位置
		
		return m;
	}
	
	private static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	
	public static void main(String[] args) {
		int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
		quickSort_inplace(unsortedArray, 0, 7);
		System.out.println("After sort:");
		for (int item : unsortedArray) {
			System.out.print(item + " ");
		}
	}
}

