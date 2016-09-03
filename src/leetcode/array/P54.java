package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P54 {
	// 将自然数以螺旋方式填入方阵
	public int[][] spiralOrder_set(int n) {
		return null;
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
			for (int j = bgnJ; j <= endJ && cnt < N * M; j++) {
				result.add(matrix[bgnI][j]);
				cnt++;
			}
				
			for (int i = bgnI + 1; i <= endI && cnt < N * M; i++) {
				result.add(matrix[i][endJ]);
				cnt++;
			}
			
			for (int j = endJ - 1; j >= bgnJ && cnt < N * M; j--) {
				result.add(matrix[endI][j]);
				cnt++;
			}
			// 注意这里的条件没有等号
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
	public void test() {

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
}
