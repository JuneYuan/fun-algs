package exam;

import java.util.Scanner;

/* 巨长的英文题目
 * Fabric, images, full set
 */
public class Lianjia3_fabric {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int[] size = new int[N];
		int[] ratio = new int[N];
		for (int i = 0; i < N; i++) {
			size[i] = sc.nextInt();
			ratio[i] = sc.nextInt();
		}
		
		int unit = 0;
		for (int i = 0; i < N; i++) {
			unit += size[i] * ratio[i];
		}
		
		int a = 36 * 36 / (unit);
		int b = 2 * a;
		int c = 3 * a + 1;

		System.out.println(a + " " + b + " " + c);
		sc.close();
	}		  
	

}
