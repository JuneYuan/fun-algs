package leetcode1st.datastruct;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P378 {

    public int kthSmallest_MaxHeap(int[][] matrix, int k) {
    	// 默认是小根堆
    	PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
    		public int compare(Integer a, Integer b) {
    			return b - a;
    		}
    	});
    	int kRoot = (int) Math.floor(Math.sqrt(k));  // 答案不可能在matrix[kRoot][kRoot]右下角的方阵范围内
    	System.out.println(kRoot);
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {
    			if (i > kRoot && j > kRoot)		continue;
    			if (heap.size() < k) {	// 未达到最大容量，直接添加
    				heap.add(matrix[i][j]);
    			} else {	// 队列已满
    				if (heap.peek() <= matrix[i][j])	break;
    				else {
    					heap.add(matrix[i][j]);
    					heap.poll();
    				}
    			}
    		}
    	}
        return heap.peek();
    }

    public int kthSmallest_MinHeap(int[][] matrix, int k) {
    	PriorityQueue<Node> heap = new PriorityQueue<>();
    	int N = matrix.length;
    	for (int i = 0; i < N; i++) {
    		Node node = new Node(matrix[0][i], 0, i);
    		heap.add(node);
    	}
    	
    	for (int i = 0; i < k - 1; i++) {
    		Node curMin = heap.peek();
    		heap.poll();
    		if (curMin.x < N - 1) {
    			int nextX = curMin.x + 1;
    			int nextY = curMin.y;
    			int val = matrix[nextX][nextY];
    			Node node = new Node(val, nextX, nextY);
    			heap.add(node);
    		}
    	}
    	return heap.peek().val;
    }

    private class Node implements Comparable<Node> {
    	int val, x, y;
    	Node(int val, int x, int y) {
    		this.val = val;
    		this.x = x;
    		this.y = y;
    	}
    	
		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
    
		public String toString() {
			return "" + val;
		}
    }
    
    public int kthSmallest_Binary(int[][] matrix, int k) {
    	int N = matrix.length;
    	int bgn = matrix[0][0], end = matrix[N-1][N-1];
    	while (bgn < end) {
    		int mid = (bgn + end) / 2;
    		int cnt = 0;
    		for (int i = 0; i < N; i++) 
    			for (int j = 0; j < N; j++)
    				if (matrix[i][j] <= mid)	cnt++;    		
    		
    		if (cnt < k) {
    			bgn = mid + 1;
    		} else {
    			end = mid;
    		}
    	}
    	return bgn;
    }

}
