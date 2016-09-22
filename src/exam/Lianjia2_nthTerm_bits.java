package exam;

import java.util.Scanner;

/* 求序列 A, B, BA, BAB, BABBA, ... 第n项中"A"、"B"各有几个？
 * 规则：前一项的所有"B"->"BA", 所有"A"->"B"
 * 规律：A[n] = A[n - 1] + A[n - 2], 其中"+"号代表字符串拼接
 * 进阶规律：斐波那契序列。由于只输出A、B个数，不要求输出内容，那么每一项中，对A、B分别应用Fibonacci规律即可
 */

/* 利用规律"A[n] = A[n - 1] + A[n - 2]"，进行字符串拼接的解法，处理方式模仿Fibonacci，但代码要冗余一些。
 * 前一个版本写的是直接字符串拼接，TLE，所以曲折一步，先使用int类型进行计算，再还原为String，就快得多
 */
public class Lianjia2_nthTerm_bits {
	public static void main(String[] args) {
		String[] sequence = helper();	// 预处理，得到整个序列，即所有项，之后只需按下标索引
		
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		String str = sequence[K];		// 这就是第k项了
		
		int ans1 = countOne(str);		// 计算并输出A、B个数
		int ans0 = str.length() - ans1;
		System.out.println(ans0 + " " + ans1);
		sc.close();
	}		  

	private static String[] helper() {
		String[] result = new String[46];
		Integer[] nums = new Integer[46];
		
		// a, b暂存某相邻两项的值，初始化为首项和次项
		Integer a = 0;
		Integer b = 1;
		// 计算nums[]每一项的值
		nums[0] = a;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = b;
			
			// 更新a, b的值
			int len = Integer.toBinaryString(a).length();
			Integer tmp = b;
			b = (b << len) + a;
			a = tmp;
		}
		
		// 使用int类型完成快速计算，最后要还原成String
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.toBinaryString(nums[i]);
		}
		
		return result;
	}
	
	private static int countOne(String str) {
		int ret = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				ret++;
			}
		}

		return ret;
	}

}
