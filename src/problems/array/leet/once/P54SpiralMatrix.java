package leetcode1st.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class P54SpiralMatrix {
	// 将自然数以螺旋方式填入方阵
	public List<Integer> spiralOrder_set(int n) {
		List<Integer> result = new ArrayList<>();
		Integer[][] grid = new Integer[n][n];
		
		int bgnI = 0, bgnJ = 0, endI = n - 1, endJ = n - 1;
		int cnt = 1, total = n * n;
		while (cnt <= total) {
			for (int j = bgnJ; j <= endJ && cnt <= total; j++) {
				grid[bgnI][j] = cnt++;
			}
			
			for (int i = bgnI + 1; i <= endI && cnt <= total; i++) {
				grid[i][endJ] = cnt++;
			}
			
			for (int j = endJ - 1; j >= bgnJ && cnt <= total; j--) {
				grid[endI][j] = cnt++;
			}
			
			for (int i = endI - 1; i > bgnI && cnt <= total; i--) {
				grid[i][bgnJ] = cnt++;
			}
			
			// narrow the circle
			bgnI++;
			endI--;
			bgnJ++;
			endJ--;
		}
		
		for (Integer[] line : grid) {
			Arrays.asList(line);
			result.addAll((Collection<Integer>)Arrays.asList(line));
		}
		return result;
	}
	
	// 螺旋遍历矩阵
	public List<Integer> spiralOrder_get(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		
		if (matrix == null || matrix.length == 0)	return result;
		if (matrix[0] == null || matrix[0].length == 0)	return result;
		
		int N = matrix.length;		// rows#
		int M = matrix[0].length;	// columns#
		int bgnI = 0, endI = N - 1;
		int bgnJ = 0, endJ = M - 1;

		int cnt = 0;
		while (cnt < N * M) {
			// right ->
			for (int j = bgnJ; j <= endJ && cnt < N * M; j++) {
				result.add(matrix[bgnI][j]);
				cnt++;
			}
			// down Y
			for (int i = bgnI + 1; i <= endI && cnt < N * M; i++) {
				result.add(matrix[i][endJ]);
				cnt++;
			}
			// left <-
			for (int j = endJ - 1; j >= bgnJ && cnt < N * M; j--) {
				result.add(matrix[endI][j]);
				cnt++;
			}
			// up A（注意这里的条件没有等号）
			for (int i = endI - 1; i > bgnI && cnt < N * M; i--) {
				result.add(matrix[i][bgnJ]);
				cnt++;
			}
			
			// narrow the circle
			bgnI++;
			endI--;
			bgnJ++;
			endJ--;
		}
		
		return result; 
	}

	
	@Test
	public void testSpiralOrder_get() {
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
/*		int[][] matrix = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}
		};*/
		System.out.println(spiralOrder_get(matrix));
	}

	@Test
	public void testSpiralOrder_set() {
		System.out.println(spiralOrder_set(6));
	}
}
