package interview.sort;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class Practice {
	private static Integer[] a = { 3, 1, 5, 7, 2, 4, 9, 6 };
	private static Integer[] b = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 3,9, 10};

	public static void bubble(Integer[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N-1-i; j++)
				if (a[j] > a[j + 1])
					swap(a, j, j + 1);
	}

	public static void insert(Integer[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1])
					swap(a, j, j - 1);
				else
					break;
			}
		}
	}
	
	public static void select(Integer[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int mn = i;
			for (int j = i; j < N; j++)
				if (a[j] < a[mn])
					mn = j;
			swap(a, i, mn);
		}
	}
	
	public static void shell(Integer[] a) {
		int N = a.length;
		int[] gap = {33936, 13776, 4592, 1968, 861, 336, 112, 48, 21, 7, 3, 1};
		for (int h : gap) {
			if (a.length > h) {
				for (int i = h; i < N; i++)
					for (int j = i; j >= h; j -= h) {
						if (a[j] < a[j - h])
							swap(a, j, j - h);
						else 	break;
					}
				
			}
		}
	}
	
	public static void quick(Integer[] a) {
		
	}
	
	private static void swap(Object[] a, int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {

	}

	@Test
	public void testInsert() {
		insert(b);
		System.out.println(Arrays.toString(b));
	}
	
	@Test
	public void testSelect() {
		select(b);
		System.out.println(Arrays.toString(b));
	}

	@Test
	public void testShell() {
		shell(b);
		System.out.println(Arrays.toString(b));
	}

}
