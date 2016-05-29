package interview;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Merge {
	private static Comparable[] aux;
	
	// 这里都是静态方法，不需要构造函数
	
	// 步骤：1. 把数组分为两部分；2. 分别将每部分排好序（递归地）；3. 合并两部分
	public static void mergeSort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1, 0);
	}
	
	private static void sort(Comparable[] a, int lo, int hi, int dep) {
for (int i = 0; i < dep; i++)	StdOut.print("    ");
StdOut.println(String.format("sort(a[], %d, %d)", lo, hi));		
		if (hi <= lo)	return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid, dep+1);
		sort(a, mid + 1, hi, dep+1);
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		// 复制a[]到aux[]
		for (int k = lo; k <= hi; k++)	aux[k] = a[k];
		// 归并
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)		a[k] = aux[j++];  //左半边遍历完了
			else if (j > hi)	a[k] = aux[i++];  //右半边遍历完了
			else if (less(aux[i], aux[j]))	a[k] = aux[i++];  // a[i]比a[j]小
			else				a[k] = aux[j++];    // j 位置较小
		}
		
		assert isSorted(a);
	}

	
	public static void bottomUpMergeSort(Comparable[] a) {
		aux = new Comparable[a.length];
		int N = a.length;
		for (int sz = 1; sz < N; sz += sz)	// sz是子序列的长度，依次为 1, 2, 4, 8, 16, ... ，直到 N			
			for (int lo = 0; lo < N - sz + 1; lo += 2*sz)	// lo是合并所得子序列的下标，如sz=2时，lo依次为 0, 4, 8,...
				merge(a, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
	}
	
	
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo; i < hi; i++)
			if (less(a[i+1], a[i]))	 return false;
		
		return true;
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)	StdOut.print(String.format("%s  ", a[i]));	
		StdOut.println();
	}
	
	
	public static void main(String[] args) {
		String[] a = (new In()).readAll().split(" ");
		for (int i = 0; i < a.length; i++)	StdOut.print(String.format("%-3d", i));		StdOut.println();
		show(a);
		bottomUpMergeSort(a);
		//mergeSort(a);
		show(a);
	}
}
