import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1187Divisors {
	private static int N;
	private static int[] divs;  // divisors
	
	public static int brute() {
		for (int i = 1; i * i <= N; i++)
			for (int j = i, t = i * j; t <= N; j++, t = i * j)
				divs[t] += j == i ? 1 : 2;

		int ret = 1; // divisors[1] = 1
		for (int i = 1; i <= N; i++) {
			if (divs[i] > divs[ret])
				ret = i;
		}
		
		return ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		divs = new int[N + 1];
		
		int ret = brute();
		System.out.println(ret);

		scanner.close();
	}
}
