import java.util.Scanner;

public class P1032New {
	/*
	 * #1032 : 最长回文子串
	 */
	private static int L, L1;
	private static String oldStr, newStr, Ret;
	private static String[] f;		// f[i]: 以 i 为中心的最长子串
	private static int[] p;	// f[i] 的长度

	public static void manacher(Scanner scanner) {
		int id = 0, right = 0;
		int max = 0;
		for (int i = 0; i < newStr.length(); i++) {
			p[i] = 1;
			if (right > i) {
				int j = 2*id - i;
				if (i + p[j] < right)
					p[i] = p[j];
				else
					p[i] = right - i;
			}
			
			char x = newStr.charAt(i - p[i]);
			char y = newStr.charAt(i + p[i]);
			while (i - p[i] >= 0 && i + p[i] < L1 && x == y) {
				p[i]++;
			}
			
			if (p[i] + i > right) {
				id = i;
				right = p[i] + i;
			}
			
			if (max < p[i] - 1)
				max = p[i] - 1;
			
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			oldStr = scanner.next();
			newStr = "$";
			L = oldStr.length();
			L1 = 2*L + 1;
			for (int i = 0; i < L1; i++) {
				newStr += (i%2 == 0) ? "#" : oldStr.charAt(i/2);
			}
			
			p = new int[L1];			
						
			manacher(scanner);
		}		
		scanner.close();
	}

}
