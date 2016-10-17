package exam;

import java.util.*;

/*
倒序输出一句话中的单词
 */
public class ZhongRuanRongXin2_reverseWords {
 	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int i = 0; i < T; i++) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			for (int j = 0, k = words.length - 1; j < k; j++, k--) {
				String tmp = words[j];
				words[j] = words[k];
				words[k] = tmp;
			}

			for (int j = 0; j < words.length; j++) {
				System.out.print(words[j]);
				if (j < words.length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		in.close();
	}
  
}