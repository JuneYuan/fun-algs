package basis.sorting;

import java.util.Arrays;

public class QuickSort1 {

	public static void qSort(int[] a) {
		qSort(a, 0, a.length - 1);
	}

	// 想搞清楚每一个布尔条件
	public static void qSort(int[] a, int l, int u) {
		System.out.println(Arrays.toString(a));

		// 会出现(l > u)吗？
		if (l >= u) {
			return;
		}

		int pivot = a[l], left = l + 1, right = u;
		// 为什么有等号？
		while (left <= right) {
			while (left <= right && a[left] < pivot) {
				left++;
			}

			while (left <= right && a[right] >= pivot) {
				right--;
			}

			if (left < right) {
				swap(a, left, right);
			}
		}
		swap(a, l, right);

		qSort(a, l, right - 1);
		qSort(a, right + 1, u);
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] unsortedArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
		qSort(unsortedArray);
		System.out.println("After sort: " + Arrays.toString(unsortedArray));
	}

}
