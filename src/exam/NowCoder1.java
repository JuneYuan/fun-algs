package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class NowCoder1 {
	private static final int N = 1000000;


	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int a0 = 1, a1 = 1, t;
		list.add(a0);
		list.add(a1);
		while (a1 < N) {
			t = a0 + a1;
			a0 = a1;
			a1 = t;
			list.add(a1);
		}

		while (sc.hasNext()) {
			int n = sc.nextInt();
			int ret = 0;
			
			int k = list.size() - 1;
			while (n < list.get(k))
				k--;
					
			while (n > 0 && k >= 0) {
				int val = list.get(k);
				if (n >= val) {
					n -= val;
					ret++;
				}
				k--;
			
			}
			
			System.out.println(ret);
		}

		sc.close();
	}

}
