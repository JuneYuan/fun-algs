package basis.sorting;

public class Selections {

	public static void selectionSort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[minIdx]))	minIdx = j;
			}
			exch(a, i, minIdx);
		}
	}
	
	public static void heapSort(Comparable[] pq) {
		int N = pq.length;
		// 把待排序列当成一个完全二叉树，先构造大根堆（编号从1开始）——
		// 从最右侧叶子节点的父节点开始，逐个调整，直至二叉树的根
		// 调整完后，二叉树成为一个大根堆
		for (int k = N/2; k >= 1; k--)
			sink(pq, k, N);
		
		// 选择排序：取出堆顶元素，重新调整二叉树顺序；重复N-1次
		while (N > 1) {
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
	}
	private static void sink(Comparable[] pq, int k, int N){
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && less(pq[j], pq[j+1]))	j++;	// 有右孩子的情况下，令j取左右孩子中较大者
			if (!less(pq[k], pq[j]))	break;			// 若当前节点>=孩子节点，意味着已经是大根堆了，不必继续调整
			exch(pq, k, j);
			k = j;
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
