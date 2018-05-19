package exam;

import java.util.*;

/* 
N*M的加权非负矩阵中，选出一些方格，
使得任意两个0权方格之间有路连通，且所选出的方格权和最小
范围：N, M, K（0权方格数目）<= 10
 
输入：第一行N, M, 描述方格数目；之后N行是描述这个矩阵
输出：选出的方格的权和

样例：
4 4
0 1 1 0
2 5 5 1
1 5 5 1
0 1 1 0 => 6
 */
public class YiDian2_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int N = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            int[] nums = new int[N + 1];
            // 从一楼开始
            for (int i = 1; i <= N; i++) {
            	nums[i] = in.nextInt();
            }
            
            Deque<Integer> result = bfs(N, A, B, nums);
            int cnt = result.size();
            if (cnt == 0) {
            	System.out.println(-1);
            } else {
            	System.out.println(cnt - 1);
            	for (int i = 0; i < cnt; i++) {
            		if (i > 0) {
            			System.out.print(" ");
            		}
            		System.out.print(result.removeFirst());
            	}
            	System.out.println();
            }
            
            // 输出格式
        }
    }
	
	
	private static Deque<Integer> bfs(int N, int A, int B, int[] nums) {
		Deque<Integer> ret = new LinkedList<>();
		
		int[] father = new int[N + 1];
		
		
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();  // 队列里存的是楼层
		queue.offer(A);
		while (!queue.isEmpty()) {
			int qLen = queue.size();
			while (qLen-- > 0) {
				int p = queue.poll();
				if (p == B) {
					int x = B;
					do {
						ret.addFirst(x);
						x = father[x];
					} while (x != A);
					ret.addFirst(A);			
					
					return ret;
					// return cnt;
				}
				
				int p1 = p - nums[p];
				if (p1 >= 0) {
					queue.offer(p1);
					father[p1] = p;
				}
				
				int p2 = p + nums[p];
				if (p2 <= N) {
					queue.offer(p2);
					father[p2] = p;
				}
			}
			
			cnt++;
		}
		
		return ret;
	}

}
