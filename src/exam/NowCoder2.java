package exam;

import java.util.Scanner;

public class NowCoder2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] a = new int[n+1];
			int ret = 0;
			
			for (int i = n, j = 1; i >= 1; i--, j++) {
				if (i == n) 
					a[n] = 1;
				else
					a[i] = a[i+1] + j;
				
				ret += a[i];
				if (i % 2 == 0)
					ret += a[i];
			}
			
			System.out.println(ret);
		}
		sc.close();
	}

}
