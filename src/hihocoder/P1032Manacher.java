package hihocoder;
import java.util.Scanner;

public class P1032Manacher {
	/*
	 * #1032 : 最长回文子串
	 */
	private static int L, L1;
	private static String oldStr, Ret;
	private static char[] newStr;
	private static String[] f;
	private static int[] helper;
	
	public static void palindromeSubStr(Scanner scanner) {
		Ret = oldStr.substring(0, 1);
		int j = 0;  // 相当于题解中的 id
		
		// 枚举中心位置
		for (int midIdx = 1; midIdx < L1 - 1; midIdx++) {
			String subStr;
			int span = midIdx < L1 / 2 ? midIdx : L1 - 1 - midIdx;
			
			// 找出 f(midIdx) 的最小值，或者是 k 的循环初始值
			int t = 2 * j - midIdx;
			if (t >= 0 && t < helper.length) {
				int c = helper[t];
				int d = helper[j] - 2 * (midIdx - j);
				j = c < d ? c : d;
				j = j < 1 ? 1 : j;
				j = j > span ? span : j;
			}
			
			for (int k = j; k <= span; k++) {
				char x = newStr[midIdx - k];
				char y = newStr[midIdx + k];
				subStr = String.valueOf(newStr).substring(midIdx - k, midIdx + k + 1);
				subStr = subStr.replaceAll("#", "");
				if (x == y && f[midIdx].length() <= subStr.length())
					f[midIdx] = subStr;
				else
					break;
			}
			
			// 找出使其右边界 j + f(j) / 2 最大的 j
			helper[midIdx] = f[midIdx].length();
			int a = midIdx + helper[midIdx] / 2;
			int b = midIdx - 1 + helper[midIdx - 1] / 2;
			if (a > b) {
				j = midIdx;
			}
			
			if (f[midIdx].length() > Ret.length()) {
				Ret = f[midIdx];
			}
		}
		
		System.out.println(Ret.length());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			oldStr = scanner.next();
			L = oldStr.length();
			L1 = 2*L + 1;
			newStr = new char[L1];
			f = new String[L1];
			helper = new int[L1];
			
			for (int t = 0; t < L1; t++)
				newStr[t] = (t%2 == 0) ? '#' : oldStr.charAt(t/2);
						
			for (int t = 0; t < L1; t++) {
				f[t] = Character.toString(newStr[t]);
				helper[t] = 1;
			}
			
			palindromeSubStr(scanner);
		}		
		
		scanner.close();
	}

}
