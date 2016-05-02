package interview;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exchanges {

	public static void bubbleSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (less(a[j+1], a[j]))	exch(a, j, j+1);
			}
		}
	}

	public static void quickSort(Comparable[] a) {
		StdRandom.shuffle(a);
		quickSort(a, 0, a.length - 1);
	}
	private static void quickSort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)	return;
		int m = partition(a, lo, hi);
		quickSort(a, lo, m-1);
		quickSort(a, m+1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while (!less(v, a[++i]))	// 移动左侧指针i，找到需要交换的元素
				if (i == hi)	break;
			while (!less(a[--j], v))	// 移动右侧指针j，找到需要交换的元素
				if (j == lo)	break;
			
			if (i >= j)	break;			// 当两个指针位置交叉时停止移动
			
			exch(a, i, j);			
		}
		
		exch(a, lo, j);					// 把partition元素放到正确位置
		return j;
	}
	
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)	
			StdOut.print(String.format("%s  ", a[i]));	
		StdOut.println();
	}
	
	public static void main(String[] args) {
		String[] a = (new In()).readLine().split(" ");
		for (int i = 0; i < a.length; i++)	StdOut.print(String.format("%-3d", i));		StdOut.println();
		show(a);
		quickSort(a);
		show(a);
	}
}
