package interview;

import java.util.Arrays;

public class Permutation {
	private static void swap(char[] arr, int i, int j) {
		char ch = arr[i];
		arr[i] = arr[j];
		arr[j] = ch;
	}
	
	// 生成arr[k:m]的所有排列方式
	private static void perm(char[] arr, int k, int m) {
		 if (k == m)	// 得到了一个排列方式
			 System.out.println(Arrays.toString(arr));
		 else {			
			 // arr[k:m]有多种排列方式，递归地求出来
			 for (int i = k; i <= m; i++) {
				 swap(arr, i, k);
				 perm(arr, k+1, m);
				 swap(arr, i, k);				 
			 }
		 }
	}
	
	private static void perm(char[] arr) {
		perm(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		char[] sequence = new String("abcd").toCharArray();
		perm(sequence);
	}

}
