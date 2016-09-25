package leetcode.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class P397 {
    // BFS解法
    public int integerReplacement_BFS(int N) {
		if (N == 1)	return 0;
		
		if (N == Integer.MAX_VALUE) {
			int a = N - 1;
			int b = N / 2 + 1;
			return Math.min(bfs(a) + 1, bfs(b) + 2);
		}
		
		return bfs(N);
	}
	
    private int bfs(int N) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		while (!queue.isEmpty()) {
			result++;
			int qLen = queue.size();
			while (qLen-- > 0) {
				Integer temp = queue.poll();
				Set<Integer> possibleNextValues = new HashSet<>();
				if ((temp.intValue() & 1) == 0) {
					possibleNextValues.add(temp / 2);
				} else {
					possibleNextValues.add(temp - 1);
					possibleNextValues.add(temp + 1);
				}
				
				for (Integer nextValue: possibleNextValues) {
					if (nextValue.equals(1))	return result;
					queue.offer(nextValue);
					
				}
			}
		}
		
		return -1;
	}

    // DP_递归_不带自定义参数
    public int integerReplacement_DFS2(int N) {
    	if (N == 1)  return 0;
    	
    	if ((N & 1) == 0) {
    		return integerReplacement_DFS2(N / 2) + 1;
    	} else {
    		int len1 = integerReplacement_DFS2(N - 1) + 1;
    		/* (N >> 1) + 1 等价于 (N + 1) / 2
    		 * 因为转换过程是：(N+1)/2 -> (N+1) -> N，所以len2采用如下方式计算
    		 * 这是为了避免当N等于MAX_INT时，(N + 1)溢出
    		 */
    		int len2 = integerReplacement_DFS2((N >> 1) + 1) + 2;
    		return Math.min(len1, len2);
    	}
    }
    
    // DP_递归_带有自定义参数
    public int integerReplacement_DFS1(int N) {
    	if (N == Integer.MAX_VALUE) {
    		int a = N - 1;
    		int b = N >> 1 + 1;
			return Math.min(dfs(a, 1), dfs(b, 2));    		
    	}
    	
    	return dfs(N, 0);
    }
    
    private int dfs(int N, int depth) {
    	if (N == 1)	return depth;
    	
    	if ((N & 1) == 0) {
    		return dfs(N >> 1, depth + 1);
    	} else {
    		int len1 = dfs(N - 1, depth + 1);
    		int len2 = dfs(N + 1, depth + 1);
    		return Math.min(len1, len2);
    	}
    }

	/* DP_迭代_逆向
	 * 定义状态dp(i): 表示正整数i变换到1需要的最少步数
	 * 转化方程：dp(可能通过一步变换得到i的那些值) = dp(i) + 1，具体跟i的奇偶性有关
	 * 举例：dp(14) = dp(7) + 1; dp(15, 17, 32) = dp(16) + 1
	 */
    public int integerReplacement_DP2(int N) {
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int idx1 = 2 * i;
			int idx2 = i + 1;
			
			// dp[idx] != 0 means it has been visited
			if ((i & 1) != 0) {  // odd number
				if (idx1 <= N && dp[idx1] == 0) {
					dp[idx1] = dp[i] + 1;
				}
			} else {	// even number
				if (idx1 <= N && dp[idx1] == 0) {
					dp[idx1] = dp[i] + 1;
					
					// 判断idx1是否2的幂
					if ( (idx1 & (idx1 - 1)) == 0 ) {
						dp[idx1 - 1] = dp[idx1] + 1;
					}
				}
				if (idx2 <= N && dp[idx2] == 0) {
					dp[idx2] = dp[i] + 1;
				}
			}
			
			if (dp[N] != 0)	break;
		}
		
		return dp[N];
	}    
    
    /* DP_迭代_正向
	 * 定义状态dp(i): 表示正整数i变换到1需要的最少步数
	 * 转化方程：dp(i) = min{dp(i下一步可能变换到的值)} + 1，具体跟i的奇偶性有关
	 * 举例：dp(20) = dp(10) + 1; dp(15) = min{dp(14), dp(16)} + 1
     */
    public int integerReplacement_DP1(int N) {
    	// 代码略
    	return -1;
    }
	
	@Test
	public void testCorrectness() {
System.out.println(Integer.MAX_VALUE);
		int BGN = 2, MAX = 64;
		int power = 1;
		for (int k = BGN; k <= MAX; k++) {
			System.out.printf("n=%d, steps=%d\n", k, integerReplacement_DFS1(k));
			
			if (Math.pow(2, power) - k < Math.pow(10, -2)) {
				power++;
				System.out.println();
			}
		}
	}

	
	@Test
	public void testTime() {
		int N = Integer.MAX_VALUE;
		long start = System.currentTimeMillis();
		System.out.println(integerReplacement_BFS(N));
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start) + "ms");
	}

	@Test
	public void testDP() {
		int BGN = 15, MAX = 100;
		for (int k = BGN; k <= MAX; k++) {
			int ret1 = integerReplacement_DFS1(k);
			int ret2 = integerReplacement_DP2(k);
			System.out.printf("dfs(%d) = %d, ", k, ret1);
			System.out.printf("dp(%d) = %d\n", k, ret2);
			// System.out.println("n=" + k + ": " + (ret1 == ret2 ? "true" : "false"));
		}
	}
}
