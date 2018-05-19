package exam;

/* 
求序列 A, B, BA, BAB, BABBA, ... 第n项中"A"、"B"各有几个？
规则：前一项的所有"B"->"BA", 所有"A"->"B"
规律：A[n] = A[n - 1] + A[n - 2], 其中"+"号代表字符串拼接
进阶规律：斐波那契序列。由于只输出A、B个数，不要求输出内容，那么每一项中，对A、B分别应用Fibonacci规律即可
 */

// Fibonacci 解法
public class QiNiu_fibonacci {
	public static void main(String[] args) {
		long[] ans = helper();		
		
		int count = 0;
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] % 7 == 0)
				count++;
		}

		System.out.println(count);
	}		  

	private static long[] helper() {
		long[] result = new long[1000];
		
		result[0] = 1;  result[1] = 1;
		for (int i = 2; i < result.length; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		
		return result;
	}
	

}
