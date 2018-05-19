import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class P1153_ {
	private static int[][] dire = {
			{},
			{2, 4}, {3, 5}, {6},
			{5, 7}, {6, 8}, {9},
			{8}, {9, 0}, {}
	};
	private static SortedSet<Integer> ss = new TreeSet<>();
	
	public static void dfs(int digit, int val, int cnt, int dep) {
		ss.add(val);
/*for (int i = 0; i < dep; i++)	System.out.print("  ");
System.out.printf("dfs(%d, %d)  a=", digit, val, cnt);
System.out.println(ss);*/
		
		int n = dire[digit].length;
		if (n == 0)	
			ss.add(10 * val + digit);
		else {
			for (int i = 0; i < n; i++) {
				dfs(dire[digit][i], 10*val + digit, cnt + 1, dep+1);
				dfs(dire[digit][i], val, cnt, dep+1);
			}
		}
	}
	
	public static void main(String[] args) {
		dfs(1, 0, 0, 0);  // 预先处理出所有可能得到的数字
		Object[] a = ss.toArray();
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int num = sc.nextInt();
			int idx = Arrays.binarySearch(a, num);
			if (idx >= 0)	System.out.println(a[idx]);
			else	System.out.println(a[-idx - 2]);
		}		
		sc.close();
	}

}
