package exam;

import java.util.Scanner;

/* 爱探索的葫芦娃
1
5 5 3 1
##--#
###--
----#
--#-#
###--
*/
public class Hulu3_cave {
	private static int n, m, H, s;	// m为行数，n为列数，H为梯子高度，s为（横向）允许跳跃次数
	private static char[][] map;	// map为输入的山洞地形
	
	private static int[] id;
	private static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			n = sc.nextInt();	// n是列，m是行！
			m = sc.nextInt();
			H = sc.nextInt();
			s = sc.nextInt();
			map = new char[m][n];
			for (int i = 0; i < m; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			System.out.println(explore());

		}
		
		sc.close();
	}

	private static int explore() {
		int result = 0;
		// Init
		id = new int[n * m];
		rank = new int[n * m];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			rank[i] = 1;
		}
		
		// Union-find
		// Traverse -> and ^, with 0 jump
		for (int r = m - 1; r >= 0; r--) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == '#') {  // 漏写这个判断，调试了很久……
					tryRightward(r, c);				
					tryUpward(r, c);	
				}
			}
		}
		result += rank[find(hash(m - 1, 0))];
		
		// Deal with jumps
		if (s > 0) {
			int mx1 = 0, mx2 = 0;	// track top 2 growth (if exist)
			for (int r = m - 1; r >= 0; r--) {
				for (int c = 0; c < n; c++) {
					if (map[r][c] == '#' && c + 2 < n && map[r][c + 2] == '#') {  // 漏写map[r][c] == '#'
						int curr = find(hash(r, c));
						int right = find(hash(r, c + 2));
						if (right != curr) {
							int growth = rank[right];
							if (growth > mx1) {
								mx1 = growth;
							} else if (growth > mx2) {
								mx2 = growth;
							}
						}
					}
				}
			}
			
			if (s == 1) {
				result += mx1;
			} else if (s == 2) {
				result += mx2;
			}
		}
		
		return result;
	}
	
	private static void tryRightward(int r, int c) {
		if (c + 1 < n && map[r][c + 1] == '#') {
			int a = hash(r, c);
			int b = hash(r, c + 1);
			union(a, b);
		}		
	}
	
	private static void tryUpward(int r, int c) {
		for (int h = r - 1; h >= r - H; h--) {
			if (h >= 0 && map[h][c] == '#') {
				int curr = hash(r, c);
				int above = hash(h, c);
				union(curr, above);
			}
		}
	}
	
	private static boolean union(int a, int b) {
		int idA = find(a);
		int idB = find(b);
		if (idA == idB)	 return false;	//	已在同一集合，未执行union操作
		
		if (rank[idB] > rank[idA]) {
			rank[idB] += rank[idA];
			id[idA] = idB;
		} else {
			rank[idA] += rank[idB];
			id[idB] = idA;
		}
		
		return true;
	}
	
	private static int find(int x) {
		while (id[x] != x) {
			x = id[x];
		}
		return x;
	}

	private static int hash(int r, int c) {
		return r * m + c;
	}

}
