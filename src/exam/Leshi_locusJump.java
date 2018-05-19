package exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 蚂蚱跳，每次可跳1步、2步、3步……，问跳到数轴上指定点最少需几步
public class Leshi_locusJump {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int x = sc.nextInt();
			int ans = bfs(x);
			System.out.println(ans);
		}
		
		sc.close();
	}
    
	private static int bfs(int N) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int qLen = queue.size();
			while (qLen-- > 0) {
				int temp = queue.poll();
				if (temp == N) {
					return result;
				}
				queue.offer(temp - (result + 1));
				queue.offer(temp + (result + 1));
			}
			
			result++;
		}
		
		return -1;
	}

}
