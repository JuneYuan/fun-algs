package exam;
import org.junit.Test;

// 城市规划－并查集
public class Baidu1_bigHome {
	private static int n;
	private static int m;
	private static int[] area;
	private static int[] father;
	
	public static int bigHome(int[][] grid) {
		int result = 0;
		n = grid.length;
		m = grid[0].length;
		int nm = n * m;			// 二维转成一维
		area = new int[nm];		// area[i]在i为某连通区域“代表元素”时，表示这个连通区域的面积（即其中"1"的个数）
		father = new int[nm];	// father[i]表示元素i的父节点（与之连通）
		
		// init: 所有的元素，area都为1，father都为自己
		for (int i = 0; i < nm; i++) {
			area[i] = 1;
			father[i] = i;
		}
		
		// traverse union: 遍历grid[][]，遇到相邻的"1"执行union()
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = hash(i, j);
				if (i + 1 < n) {
					if (grid[i][j] == 1 && grid[i + 1][j] == 1) {
						union(a, hash(i + 1, j));
					}
				}
				if (j + 1 < m) {
					if (grid[i][j] ==1 && grid[i][j + 1] == 1) {
						union(a, hash(i, j + 1));
					}
				}
			}
		}			
		
		// count: 统计结果
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result = Math.max(result, area[find(hash(i, j))]);
			}
		}
		
/*		// 这里是调试，打印area[][]的内容
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(area[hash(i, j)] + " ");
			}
			System.out.println();
		}*/
		
		return result;
	}

	private static boolean union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if (fa == fb) {
			return true;
		}
		
		if (area[fa] > area[fb]) {
			area[fa] += area[fb];
			father[fb] = fa;
		} else {
			area[fb] += area[fa];
			father[fa] = fb;
		}
		
		return false;
	}

	private static int find(int x) {
		if (father[x] != x) {
			father[x] = find(father[x]);
		}
		
		return father[x];
	}

	private static int hash(int i, int j) {
		return i * n + j;
	}

	
	@Test
	public void test() {
		int[][] grid = new int[][]{	// answer = 7
			{0, 0, 1, 1, 1},
			{0, 1, 1, 0, 1},
			{0, 0, 0, 0, 1},
			{0, 0, 1, 1, 0},
			{0, 0, 1, 0, 0},
		};
/*		int[][] grid = new int[][] {
			{0, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 0}
		};*/
		int ans = bigHome(grid);
		System.out.println(ans);
	}
}

