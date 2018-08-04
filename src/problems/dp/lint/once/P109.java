package problems.dp.lint.once;

import java.util.Arrays;

import org.junit.Test;

public class P109 {
	// Method 1 - Traverse without hashmap
	public int minimumTotal_traverse(int[][] triangle) {
		if (triangle == null || triangle.length == 0)	return -1;
		
		int result = Integer.MAX_VALUE;
		int[] resultRef = {result};
		dfs(0, 0, 0, triangle, resultRef);
		
		return resultRef[0];
	}
	private void dfs(int x, int y, int sum, int[][] triangle, int[] resultRef){
		if (x == triangle.length) {
			if (sum < resultRef[0]) {
				resultRef[0] = sum;
			}
			return;
		}
		
		dfs(x + 1, y, (sum + triangle[x][y]), triangle, resultRef);
		dfs(x + 1, y + 1, (sum + triangle[x][y]), triangle, resultRef);
	}

	// Method 2 - Divide and Conquer without hashmap
	public int minimumTotal_divideConquer(int[][] triangle) {
		if (triangle == null || triangle.length == 0)	return -1;
		
		int result = dfs(0, 0, triangle);
		return result;
	}
	private int dfs(int x, int y, int[][] triangle) {
		if (x == triangle.length) {
			return 0;
		}
		
		int below = dfs(x + 1, y, triangle);
		int belowRight = dfs(x + 1, y + 1, triangle); 
		return triangle[x][y] + Math.min(below, belowRight);
	}

	// Method 3 - Divide and Conquer with hashmap
    public int minimumTotal_dcWithHashmap(int[][] triangle) {
    	if (triangle == null || triangle.length == 0)	return -1;
    	
    	int[][] map = triangle.clone();
    	for (int i = 0; i < triangle.length; i++) {
    		map[i] = Arrays.copyOf(triangle[i], triangle[i].length);
    	}
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[i].length; j++) {
    			map[i][j] = Integer.MIN_VALUE;
    		}
    	}
    	int result = dfs(0, 0, triangle, map);
    	
    	return result;
    }
    private int dfs(int x, int y, int[][] triangle, int[][] map) {
    	if (x == triangle.length) {
    		return 0;
    	}
    	
    	// Integer.MIN_VALUE means no value yet
    	if (map[x][y] != Integer.MIN_VALUE) {
    		return map[x][y];
    	}
    	
    	int x1y = dfs(x + 1, y, triangle, map);
    	int x1y1 = dfs(x + 1, y + 1, triangle, map);
    	map[x][y] = Math.min(x1y, x1y1) + triangle[x][y];
    	return map[x][y];
    }
    
    // Method 4 - Dynamic Programming
    public int minimumTotal_dp_bottomUp(int[][] triangle) {
    	if (triangle == null || triangle.length == 0)	return -1;
    	
    	int[][] map = triangle.clone();
    	// init
    	final int N = triangle.length;
    	for (int j = 0; j < N; j++) {
    		map[N - 1][j] = triangle[N - 1][j];
    	}
    	// process
    	for (int i = N - 2; i >= 0; i--) {
    		for (int j = 0; j <= i; j++) {
    			map[i][j] = triangle[i][j] + Math.min(map[i+1][j], map[i+1][j+1]);
    		}
    	}
    	
    	return map[0][0];
    }

    public int minimumTotal_dp_topDown(int[][] triangle) {
    	if (triangle == null || triangle.length == 0)	return -1;
    	
    	int[][] map = triangle.clone();
    	// map[0][0] = triangle[0][0];
    	final int N = triangle.length;
    	for (int i = 1; i < N; i++) {
    		map[i][0] = map[i - 1][0] + triangle[i][0];
    		for (int j = 1; j < i; j++) {
    			map[i][j] = Math.min(map[i - 1][j], map[i - 1][j - 1]) + triangle[i][j];
    		}
    		map[i][i] = map[i - 1][i - 1] + triangle[i][i];
    	}
    	
    	int result = Integer.MAX_VALUE;
    	for (int i = 0; i < N; i++) {
    		result = Math.min(result, map[N - 1][i]);
    	}
    	
    	return result;
    }

    public int minimumTotal_dp_topDown2(int[][] triangle) {
    	if (triangle == null || triangle.length == 0)	return -1;
    	
    	int N = triangle.length;
    	int[] last = new int[N];
    	int[] current = new int[N];
    	last[0] = triangle[0][0];
    	current[0] = last[0];
    	for (int i = 1; i < N; i++) {
    		for (int j = 0; j <= i; j++) {
    			int sum = Integer.MAX_VALUE;
    			if (j != 0) {
    				sum = last[j - 1] + triangle[i][j];
    			}
    			if (j != i) {
    				sum = Math.min(sum, last[j] + triangle[i][j]);
    			}
    			current[j] = sum;
    		}
    		for (int k = 0; k <= i; k++)	last[k] = current[k];
    	}
    	
    	int result = Integer.MAX_VALUE;
    	for (int val : current) {
    		result = Math.min(result, val);
    	}
    	
    	return result;
    }
    
    
    @Test
    public void test() {
    	int[][] triangle = {{2},
    						{3, 4},
    						{6, 5, 7},
    						{4, 1, 8, 3}};
    	int x = minimumTotal_dp_topDown(triangle);
    	System.out.println(x);
    }
}
