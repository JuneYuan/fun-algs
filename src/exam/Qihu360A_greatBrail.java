package exam;

import java.util.Scanner;

public class Qihu360A_greatBrail {

	private static boolean check(String str, String seq1, String seq2) {
		boolean result = false;
		int idx1 = str.indexOf(seq1);
		if (idx1 != -1) {
			int idx2 = str.substring(idx1 + seq1.length()).indexOf(seq2);
			if (idx2 != -1) {
				result = true;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String allColors = sc.nextLine();
			String seq1 = sc.nextLine();
			String seq2 = sc.nextLine();
			
			StringBuffer sb = new StringBuffer(allColors);
			String reverseColors = new String(sb.reverse().toString());
			
			// -> check
			boolean forward = check(allColors, seq1, seq2);
			
			// <- check
			boolean backward = check(reverseColors, seq1, seq2);
			
			// get result
			if (forward && backward) 
				System.out.println("both");
			else if (forward)
				System.out.println("forward");
			else if (backward)
				System.out.println("backward");
			else 
				System.out.println("invalid");
		}
		sc.close();
	}
}
