package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* 
彩色宝石项链
输入一行字符串表示项链的宝石序列，要截取出包含A B C D E的连续一段，求剩下的最大长度。

样例：
ABCYDYE => 1
ATTMBQECPD => 3

这个写法复杂度太高
 */
public class Sohu3_necklace {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int result = 0;
			StringBuilder sb = new StringBuilder(sc.nextLine());
			int L = sb.length();
			sb.append(sb);
			String circle = sb.toString();
						
			for (int i = 0; i <= L; i++) {
				Set<Character> set = new HashSet<>();
				for (int j = i; j < i + L; j++) {
					char ch = circle.charAt(j);
					if (ch >= 'A' && ch <= 'E') {
						set.add(ch);
					}
					
					if (set.size() >= 5) {
						int drop = j - i + 1;
						int temp = drop >= L ? 0 : (L - drop);
						result = Math.max(temp, result);
					}
				}				
			}
			
			
			System.out.println(result);
		}
		
		sc.close();
	}

	

}
