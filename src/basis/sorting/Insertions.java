package basis.sorting;

public class Insertions {
	public static void insertionSort1(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			// search
			int j;
			for (j = i - 1; j >= 0; j--)
				if (less(a[j], a[i]))	 break;  // a[j] < a[i]
			// insert (shift then throw)
			if (j != i - 1) {
				Comparable temp = a[i];
				for (int k = i; k > j + 1; k--)
					a[k] = a[k - 1];
				a[j + 1] = temp;
			}
		}
	}

	public static void insertionSort2(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			// insert while search
			Comparable temp = a[i];
			int j;
			for (j = i - 1; j >= 0 && less(a[i], a[j]); j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}

	public static void insertionSort3(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0 && less(a[j+1], a[j]); j--)
				exch(a, j, j+1);
		}
	}

	public static void shellSort1(Comparable[] a) {
		int[] incs = {33936, 13776, 4592, 1968, 861, 336, 112, 48, 21, 7, 3, 1};
		for (int d = 0; d < incs.length; d++) {
			int h = incs[d];
			if (a.length > h) {
				for (int k = 0; k < h; k++) {
					/*
					 * 对每一组作直接插入排序（ insertionSort 只有一组，对应的 h = 1, k = 0 ）
					 */
					for (int i = k + h; i < a.length; i += h) 
						for (int j = i - h; j >= k && less(a[j + h], a[j]); j -= h)
							exch(a, j + h, j);					
				}	
			}
		}

	}

	public static void shellSort2(Comparable[] a) {
		int[] incs = {33936, 13776, 4592, 1968, 861, 336, 112, 48, 21, 7, 3, 1};
		for (int d = 0; d < incs.length; d++) {
			int h = incs[d];
			if (a.length > h) {
				for (int i = h; i < a.length; i++) 
					for (int j = i - h; j >= 0 && less(a[j + h], a[j]); j -= h)
						exch(a, j + h, j);
			}
		}

	}

	
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}
