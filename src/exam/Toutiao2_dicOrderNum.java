package exam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 字典序数字
 * 举例：1~11的数字，字典序为：1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9
 * 输入：整数n, m
 * 输出：1~n的数字，字典序第m个值是几？
 */
public class Toutiao2_dicOrderNum {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<Integer> seq = lexicalOrder(n);
		System.out.println(seq.get(m - 1));
		sc.close();
	}

	private static List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>(n);
		int curr = 1;
		for (int i = 1; i <= n; i++) {
			result.add(curr);
			if (curr * 10 <= n) {
				curr *= 10;
			} else if (curr % 10 != 9 && curr + 1 <= n) {
				curr++;
			} else {
				while ((curr / 10) % 10 == 9) {
					curr /= 10;
				}
				curr = curr / 10 + 1;
			}
		}
		
		return result;
	}
}