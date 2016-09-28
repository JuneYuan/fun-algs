package exam;
import java.util.Scanner;

/* 进程协作打印字符
 * 若干个线程同时运行，交替打印n次字符，每个线程只能打印一种字符。比如：n=3, 打印字符为A和B，那么线程1和线程2交替打印3次，屏幕输出就为ABABAB.
 * 输入：打印次数n和字符序列，空格分隔
 * 输出：打印结果
 * 注意：需要检查输入有效性，遇到错误输入时，打印error并安全退出
 */
public class Wanmei2_alterPrint {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			String[] input = sc.nextLine().split("\\s");
			boolean[] state = new boolean[128];
			String times = input[0];
			String chSeq = input[1];
			
			int n = Integer.parseInt(times);
			char[] ches = chSeq.toCharArray(); 
			for (int i = 0; i < ches.length; i++) {
				int idx = ches[i] - 'A' + 65;
				if (state[idx]) {
					throw new Exception();
				} else {
					state[idx] = true;
				}
			}
			
			for (int i = 0; i < n; i++) {				
				System.out.print(chSeq);
			}
			System.out.println();
		} catch (Exception e) {
			// 检查输入有效性
			System.out.println("error");
		}
				
		sc.close();
	}
}