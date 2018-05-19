package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/* 数串拼接成的最大数值
 * Sample:
 * [13, 312, 343] 连接成的最大整数为34331213
 * [7, 13, 4, 246] => 7424613
 * [98, 732, 4210, 42, 19] => 9873242421019
 * 代码有问题
 */
public class ZhuBaJie_strNum {
	private static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			int L1 = s1.length();
			int L2 = s2.length();
			if (L1 == L2) {
				return cmp(s1, s2);
			} else if (L1 > L2) {
				List<String> list = new ArrayList<>();
				for (int i = L2; i < L1; i += L2) {
					String str = s1.substring(i);
					list.add(str);
				}
				
				for (String seg : list) {
					if (cmp(seg, s2) != 0) {
						continue;
					} else {
						return cmp(seg, s2);
					}
				}				
			} else {
				List<String> list = new ArrayList<>();
				for (int i = L1; i < L2; i += L1) {
					String str = s2.substring(i);
					list.add(str);
				}
				
				for (String seg : list) {
					if (cmp(seg, s1) != 0) {
						continue;
					} else {
						return cmp(seg, s1);
					}
				}				
			}
			return 1;
		}
		
	}
	
	private static int cmp(String s1, String s2) {
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1;
			} else if (s1.charAt(i) > s2.charAt(i)) {
				return -1;
			}
		}
		
		if (s1.length() == s2.length()) {
			return 0;
		} else if (s1.length() > s2.length()) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			StringBuilder ret = new StringBuilder();
			int N = sc.nextInt();
			int[] A = new int[N];
			String[] S = new String[N];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				S[i] = Integer.toString(A[i]);
			}
			
			MyComparator cmp = new MyComparator();
			Arrays.sort(S, cmp);
			for (int i = S.length - 1; i >= 0; i--) {
				ret.append(S[i]);
			}
			
			System.out.println(ret);
		}
		
		sc.close();
	}
}
