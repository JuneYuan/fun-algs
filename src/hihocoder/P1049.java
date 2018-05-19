import java.util.Scanner;

public class P1049 {

	public static String postOrder(String str1, String str2) {
		if (str1.length() <= 1)
			return str1;
		else {
			char root = str1.charAt(0);
			int p = str2.indexOf(root);
			String str2L = str2.substring(0, p);
			String str2R = str2.substring(p + 1);
			String str1L = str1.substring(1, p + 1);
			String str1R = str1.substring(p + 1);
			return postOrder(str1L, str2L) + postOrder(str1R, str2R) + root;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String preOrder = scanner.next();
		String inOrder = scanner.next();
		System.out.println(postOrder(preOrder, inOrder));
		scanner.close();
	}
}
