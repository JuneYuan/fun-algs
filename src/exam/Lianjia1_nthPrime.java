package exam;

import java.util.Scanner;

// 求第n个素数
public class Lianjia1_nthPrime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 用n来作计数，i从小到大遍历自然数并判定是否素数
		int n = sc.nextInt();
		int i = 2;
		while (n > 0) {
			if (isPrime(i++)) {
				n--;
			}
		}

		System.out.println(i);
		sc.close();
	}
		  
	private static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
