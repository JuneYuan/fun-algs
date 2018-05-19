package exam;

import java.util.Scanner;

/* 
保留最大的数
输入十进制正整数number和K，求从number中去掉K个位置的数字后，保留下来的数值最大是多少。

样例：
325
1  =>35
 */
public class Sohu1_maxNum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int k = sc.nextInt();
		
		String result = s.substring(k);	// swipe first k digits
		
		for (int i = 1; i + k <= s.length(); i++) {
			StringBuilder temp = new StringBuilder();
			String a = s.substring(0, i);
			String b = s.substring(k + i);
			temp.append(a).append(b);
			
			if (compare(result, temp.toString()) < 0) {
				result = temp.toString();
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}

	private static int compare(String a, String b) {
		if (a.length() > b.length()) {
			return 1;
		} else if (a.length() < b.length()) {
			return -1;
		} else {  // equal length
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) > b.charAt(i)) {
					return 1;
				} else if (a.charAt(i) < b.charAt(i)) {
					return -1;
				}
			}
		}
		
		return 0;
	}
}
