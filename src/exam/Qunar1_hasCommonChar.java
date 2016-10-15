package exam;

import java.util.Scanner;

/*
判断两个字符串是否由相同的字符集构成
 */
public class Qunar1_hasCommonChar {
	 public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s1 = in.next();
			String s2 = in.next();
			System.out.println(hasCommonChar(s1, s2));
		}
		
		in.close();
	 }
	 
	 private static boolean hasCommonChar(String s1, String s2) {
		 boolean[] buf = new boolean[26];
		 for (int i = 0; i < s1.length(); i++) {
			 buf[s1.charAt(i) - 'A'] = true;
		 }
		 
		 for (int i = 0; i < s2.length(); i++) {
			 if (buf[s2.charAt(i) - 'A'] == false) {
				 return false;
			 }
		 }

		 
		 return true;
	 }
}
