package exam;

import java.util.Scanner;

/*
求大于给定自然数n的对称自然数（对称可理解为字符串的回文）
 */
public class Qunar2_nextSymmeticNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt() + 1;
			while (!isSymmetric(n)) {
				n++;
			}
			System.out.println(n);	
		}
			
		in.close();
	}
	
	private static boolean isSymmetric(int n) {
		String s = Integer.toString(n);
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
}
