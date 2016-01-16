package smartjune;
/*
 * hiho OJ:
 * 1. 类名为 Main; 2. 类中包含入口 main 函数; 3. 不要使用 package!
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	/*
	 * #1090 : Highway
	 */
	private static int N;
	// Key: where a car comes in, i.e. x[]; Value: the index associated
	private static TreeMap<Integer, Integer> x_idx;
	// Key: where a car leaves, i.e. y[]; Value: the time associated
	private static LinkedHashMap<Integer, Double> y_t;
	private static int[] L;
	
	private static int[] yOriginal;
	private static int[] yOrdered;
	
	public static void highway(Scanner scanner) {
		N = scanner.nextInt();
		x_idx = new TreeMap<Integer, Integer>(
				new Comparator<Integer>() {
					public int compare(Integer obj1, Integer obj2) {
						return obj2.compareTo(obj1);
					}
				});		
		yOriginal = new int[N];
		y_t = new LinkedHashMap<>(N);
		L = new int[N];	// speed limit
						
		for (int i = 0; i < N; i++) {
			x_idx.put(scanner.nextInt(), i);
			yOriginal[i] = scanner.nextInt();
			y_t.put(yOriginal[i], 0.0);			
			L[i] = scanner.nextInt();			
		}
	
		process();
	}
	
	private static void process() {
		double[] ans = new double[N];
		
		/*
		 * 对于x_idx, 既要访问排了序的x[]序列，又要知道对应的下标，所以用xMap
		 * 对于y_t, 只需要更新键值对，和访问车i的终点位置，用keySet就够了
		 */
		Set xSet = x_idx.entrySet();
		Iterator xItr = xSet.iterator();
		Map.Entry xMap;
		
		yOrdered = Arrays.copyOf(yOriginal, N);
		Arrays.sort(yOrdered);	
		
		while (xItr.hasNext()) {
			// 记录车 i 及其起点、终点位置
			xMap = (Map.Entry)xItr.next();
			int i = (Integer)xMap.getValue();
			int xOfi = (Integer)xMap.getKey();
			
			int yOfi = yOriginal[i];
			
//System.out.println("\nxi=" + xOfi + ", i=" + i);			
			
			/*
			 * 有序地遍历终点序列 y[], 选择经过这段路且在车i前面行驶的车辆加以处理
			 * tj: t of yOrdered[j], or y_t.value, see below
			 */
			double t = 0, tj = 0;
			for (int j = 0; j < N; j++) {			
				int yj = yOrdered[j];

//System.out.println("    j=" + j);				
				
				if (yj > xOfi) {
					t += 1.0 * (yj - xOfi) / L[i];
					tj = y_t.get(yj);
/*					
System.out.printf("        yj=%d\n", yj);					
System.out.printf("        t += (%d - %d) / %d = %.2f\n", yj, xOfi, L[i], t);
System.out.printf("        tj = %.2f\n", tj);
*/					
					// t 较大则更新 y_t, tj 较大则更新 t
					if (t > tj)		y_t.put(yj, t); 
					else			t = tj;
					
//System.out.println("        t=" + t + ", y_t=" + y_t.toString());				
					
					if (yj == yOfi) {
						ans[i] = t;
						break;
					}
					
					xOfi = yj;
				}

			}
		}
		
		// Output
		for (int i = 0; i < ans.length; i++)
			System.out.printf("%.2f\n", ans[i]);
	}

	
	
	/*
	 * hiho Week80
	 * #1135 : Magic Box
	 */
	public static void magicBox(Scanner scanner) {
		int[] xyz = new int[3];			// VANISH delta
		xyz[0] = scanner.nextInt();		
		xyz[1] = scanner.nextInt();
		xyz[2] = scanner.nextInt();	
		Arrays.sort(xyz);
		String seq = scanner.next();
		
		int[] balls = new int[3];		// record num of each color of ball
		int[] delta = new int[3]; 					// current delta
		int total = 0, maxNum = 0;

		for (int i = 0; i < seq.length(); i++) {
			char ch = seq.charAt(i);
			if (ch == 'R')	balls[0] += 1;
			if (ch == 'Y')	balls[1] += 1;
			if (ch == 'B')	balls[2] += 1;			

			total = balls[0] + balls[1] + balls[2];
			if (total > maxNum)
				maxNum = total;
			
			delta[0] = Math.abs(balls[0] - balls[1]);
			delta[1] = Math.abs(balls[1] - balls[2]);
			delta[2] = Math.abs(balls[2] - balls[0]);
			Arrays.sort(delta);
			if (Arrays.toString(xyz).equals(Arrays.toString(delta)))
			{ balls[0] = 0; balls[1] = 0; balls[2] = 0; total = 0; } 
			
		}
		
		System.out.println(maxNum);

	}

	
	/*
	 * ❌
	 * #1091 : Clicker 未完成！
	 */
	public static void clicker(Scanner scanner) {
		int N = scanner.nextInt();  // # heros
		int M = scanner.nextInt();  // # coins
		int[] A = new int[N];		// addon of damage raise
		int[] B = new int[N];		// multiple of level-raising-cost
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
			B[i] = scanner.nextInt();
		}
		
		int[][] f = new int[N][M];
		
		for (int v = 0; v < M; v++)
			f[0][v] = 0;
		
		for (int i = 1; i < N; i++) {
			
			for (int v = 0; v < M; v++) {
				f[i][v] = f[i][v] >= f[i][v] ? f[i][v] : f[i - 1][v];
				
				for (int lvl = 0; lvl < 146; lvl++) {
					
				}
			}
		}
		
		
		
	}	

	
	/*
	 * #1095 : HIHO Drinking Game
	 */
	public static void drinkingGame(Scanner scanner) {
		int N = scanner.nextInt();  // rounds
		int K = scanner.nextInt();  // dice-faces
		int[] d = new int[N];		// n dice's prediction
		int score = 0, rest = 0;  // match point
		
		for (int i = 0; i < N; i++) 
			d[i] = scanner.nextInt();
		
		/*
		 * T's interval: [0, N] --
		 * when T=0, Ho fails ALL; when T=n, Ho wins ALL
		 */
		int left = 0, right = K + 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			int f = f(mid, N, K, d, score, rest);
			if (f < (N + 1) / 2)
				left = mid;
			else
				right = mid;
		}
		
		System.out.println(right);
	}
	
	/*
	 * exactly follow the game rules
	 * step-by-step
	 */
	private static int f(int T, int N, int K, int[] d, int score, int rest) {		
		for (int i = 0; i < N; i++) {		
			rest += T;  // "Hi pours TmL water into Ho's cup"
			
			if (rest <= d[i])  // compare rest with Ho's dice prediction
				rest = 0;
			else {
				score++;
				rest = rest - d[i];
			}
			
		}			
		return score;
	}

	
	/*
	 * ❌
	 * #1096 : Divided Product
	 */
	
	private static ArrayList<String> solutions = new ArrayList<>();
	
	public static void dividedProduct(Scanner scanner) {
		
		int N = scanner.nextInt();
		//int M = scanner.nextInt();
		int sum = 0, mul = 1, last = 0;
		String sln = "";
		
		int cnt = bruteDFS(N, 2, last, sum, mul, 0);
		System.out.println(cnt);

	}
	
	 {
		
	}
	
	
	public static int bruteDFS(int N, int M, int last,
					int sum, int mul, int indent) {
		
for (int i = 0; i < indent; i++)
	System.out.print("    ");
String s = "";
if (N == sum) {
	s = " CHECK";
}	
System.out.println("i:" + last + " DFS(N=" + N + ", last=" + last + ", sum=" + sum + ")" + s);
		
		if (sum == N) {
			/*int x = mul % M;
			return x == 0 ? 1 : 0;*/
			return 1;
		} else {
			
			int cnt = 0;
			for (int i = last + 1; i <= N - sum; i++) {
				if (i == N)
					return cnt;
				int x = bruteDFS(N, M, i, sum + i, mul * i, indent + 1);
				cnt += x;
			}
			
			return cnt;
		}
	}
	
	/*
	 * 递归方法，暴力求解
	 */
	public static void fourLevelForLoop(Scanner scanner) {
		int N = scanner.nextInt();
		int sum = 0, mul = 1, cnt = 0;
		ArrayList<String> solutions = new ArrayList<>();
		String sln = "";
		
		for (int i = 1; sum < N; i++) {
			sum += i;
			mul *= i;
			if (sum == N) {
				cnt++;
				sln = Integer.toString(i) + " ";
				solutions.add(sln);
			} else {
				
				for (int j = i + 1; sum < N; j++) {
					sum += j;
					mul *= j;
					if (sum == N) {
						cnt++;
						sln = Integer.toString(i) + " " + Integer.toString(j);
						solutions.add(sln);
					} else {
						
						for (int k = j + 1; sum < N; k++) {
							sum += k;
							mul *= k;
							if (sum == N) {
								cnt++;
								sln = Integer.toString(i) + " " 
									  + Integer.toString(j) + " "
									  + Integer.toString(k);
								solutions.add(sln);
							} else {
								
								for (int s = k + 1; sum < N; s++) {
									sum += s;
									mul *= s;
									if (sum == N) {
										cnt++;
										sln = Integer.toString(i) + " " 
												  + Integer.toString(j) + " "
												  + Integer.toString(k) + " "
												  + Integer.toString(s);
										solutions.add(sln);
									} else {
										sum -= s;
									}
								}
							}
						}
					}
				}
			}			
		}
		
		
		for (String s : solutions) 
			System.out.println(s);
		
	}
	
	
	
	// static String prefix = "";
	
	/*
	 * ❌
	 * #1107 : Shortest Proper Prefix
	 */
	public static void shortestPrefix(Scanner scanner) {
		
		// 构建Trie树
		int N = scanner.nextInt();
		TrieNode dict = new TrieNode('*', 0);
		
		for (int i = 0; i < N; i++) {
			String word = scanner.next();
			TrieNode build = dict;
			DFS(build, word);
		}
		
		// BFS(dict);
		
		int ret = traverse(dict, 0);
		System.out.println(ret);
// System.out.println(prefix);
		
	}
	
	/*
	 * 一个节点，可能有孩子，也可能没有；没有孩子的节点，可能是当前所添加单词的最后一个字母，也可能不是。
	 */
	private static void DFS(TrieNode build, String str){	
		build.cnt++;  // 每次添加一个新单词时，都把它经过的所有节点的cnt全部＋1
		
		int N = str.length();
		char ch = str.charAt(0);
		TrieNode child = build.hasChild(ch);
		
		if (child != null) {
			if (N > 1)
				DFS(child, str.substring(1));
			else {
				
				if (child.state.equals("end")) {
					child.cnt++;
				}
				
				child.state = "end";
				return;
			}
				
		} else {
			TrieNode tn = new TrieNode(ch, 0);
			build.addChild(tn);
			if (N > 1)
				DFS(tn, str.substring(1));
			else {
				tn.state = "end";
				tn.cnt++;  // 添加某个新单词时，经历的最后一个节点
				return;
			}
				
		}		
	}
	
	
	private static int traverse(TrieNode root, int num) {
		
		if (root.cnt <= 5) {
			// prefix += root.ch + "/" + Integer.toString(root.cnt) + " ";
			return 1;
		}
		
		else {
			
			for (TrieNode tn : root.children) {
				int x = traverse(tn, 0);
				num += x;
			}
			
			return num;
		}
		
	}
	
	private static class TrieNode implements Comparable {
		char ch;
		int cnt;  // 记录以当前节点为根的子数，包含多少个单词
		String state = "mid";  // 代表当前节点是否一个单词的结束
		TreeSet<TrieNode> children = new TreeSet<>();
		
		TrieNode(char ch, int cnt)
		{ this.ch = ch; this.cnt = cnt; }
		
		// 这里耗时，最好改
		public TrieNode hasChild(char ch) {
				for (TrieNode tn : children) {
					if (tn.ch == ch)
						return tn;
				}

			return null;
		}
	
		public void addChild(TrieNode tn) {
			children.add(tn);
		}

		@Override
		public int compareTo(Object o) {
			TrieNode that = (TrieNode) o;
			if (this.ch == that.ch)
				return 0;
			return this.ch > that.ch ? 1 : -1;
		}
	
		public String toString() {
			return Character.toString(ch);
		}
	
	}
	
	// 层次遍历，验证构建trie树正确性
	private static void BFS(TrieNode dict) {
		String chs = "";
		String cnts = "";
		ArrayList<TrieNode> seq = new ArrayList<>();
		seq.add(dict);
		
		int i = 0;
		while (i < seq.size()) {
			TrieNode tn = seq.get(i);
			chs += " " + tn.ch + " ";
			cnts += String.format("%2d", tn.cnt) + " ";
			;
// System.out.print(tn.ch + " ");
			if (tn.state.equals("end")) {
				chs += "(end) ";
				cnts += "      ";
				
// System.out.print("(end) ");
			}
			
			if (tn.children != null) {
				seq.addAll(tn.children);
			}
			
			i++;
		}
		
		System.out.println(chs);
		System.out.println(cnts);
	}
	
	
	/*
	 * #1099 : Constellations
	 */
	public static void constellations(Scanner scanner) {
		int K = scanner.nextInt(); 
		int H = 0, W = 0;
		int N = 0, M = 0;
		char[][][] picture = new char[K + 1][][];
		char[][] sky = null;		
		boolean[] exist = new boolean[K];  // ???
			
		/* 
		 * 辅助记录picture中第一次出现'#'的行和列
		 * 默认初始化为 0 和 false
		 */
		int[] firstRows = new int[K];
		int[] firstCols = new int[K];
		boolean[] firstRowFound = new boolean[K]; 
		boolean[] firstColFound = new boolean[K];
	
		// EACH picture
		for (int k = 0; k <= K; k++)
		{
			H = scanner.nextInt();
			W = scanner.nextInt();	
			picture[k] = new char[H][W];

			for (int i = 0; i < H; i++) {
				String str = scanner.next();
				for (int j = 0; j < W; j++) {
					char ch = str.charAt(j);
					picture[k][i][j] = ch;
					
					if (k != K && ch == '#') {
						if (!firstRowFound[k]) {
							firstRows[k] = i;
							firstRowFound[k] = true;
						}

						if (j < firstCols[k] || !firstColFound[k]) {
							firstCols[k] = j;
							firstColFound[k] = true;
						}
					}
					
				}				
			}			
			
			if (k == K)
			{ N = H; M = W; sky = picture[K]; }			
			
			
/*			for (int a = 0; a < H; a++) {
				for (int b = 0; b < W; b++) 
					System.out.print(picture[k][a][b]);
				System.out.println();
			}
			
			if (k != K)
			System.out.println("==>" + firstRows[k] + ", " + firstCols[k] + "\n");*/

		}

		
		
	
		exist = quickMatch(exist, picture, K, firstRows, firstCols, sky, N, M);
		
		for (boolean b : exist) {
			System.out.println(b == true ? "Yes" : "No");
		}

	}

	private static boolean[] quickMatch(boolean[] exist, char[][][] picture, int K,
			 int[] firstRows, int[] firstCols,
			 char[][] sky, int N, int M) {
		
		for (int k = 0; k < K; k++) {			
			
			// 记录星图 picture[k] 中的每一颗星星
			ArrayList<Offset> list = new ArrayList<>();
			int cnt = 0;
			int H = picture[k].length;
			int W = picture[k][0].length;
			for (int picI = 0; picI < H; picI++) {
				for (int picJ = 0; picJ < W; picJ++) {
					if (picture[k][picI][picJ] == '#') {
						cnt++;				
						list.add(new Offset(picI - firstRows[k], picJ - firstCols[k]));  // 裁掉picture四周空白的地方
					}
				}
			}
			
			
			/*
			 *  判断这个星图是否存在于sky中——
			 *  枚举星空图sky的坐标为匹配的左上角；
			 */
			exist[k] = false;
			boolean flag = false;			
		
			for (int skyX = 0; skyX < N; skyX++) {
				for (int skyY = 0; skyY < M; skyY ++) {
					flag = true;
					
					for (int t = 0; t < cnt; t++) {
						int a = skyX + list.get(t).x;
						int b = skyY + list.get(t).y;
						char chS = (a < N && b < M) ? sky[a][b] : '!';
						if (chS != '#') {
							flag = false;
							break;
						}
					}
					
					if (flag) {
						exist[k] = true;
//System.out.println("Yes (" + skyX + ", " + skyY + ")");
					}
					
				}
			}
		}
		
		return exist;
	}
	
	private static class Offset {
		int x, y;
		
		Offset(int x, int y) {
			this.x = x;  this.y = y;
		}
	}
		
	// 这个方法有错误，而且超时
	private static boolean[] blindMatch(boolean[] exist, char[][][] picture, int K,
							 char[][] sky, int N, int M) {
		
		for (int k = 0; k < K; k++) {
			exist[k] = false;
			int H = picture[k].length;
			int W = picture[k][0].length;
			boolean flag = false;
			
			// 枚举星空图sky的坐标为匹配的左上角
			for (int skyX = 0; skyX < N; skyX++) {
				for (int skyY = 0; skyY < M; skyY++) {
					
					flag = true;
					for (int picX = 0; picX < H; picX++) {
						for (int picY = 0; picY < W; picY++) {
							/* 
							 * 对不对？？？
							 */							
							char chP = picture[k][picX][picY];								
							int a = skyX + picX;
							int b = skyY + picY;
							char chS = (a < N && b < M) ? sky[a][b] : '!';
							if (chP != chS) {
								flag = false;
								break;
							}
													
						}
					}
					
					if (flag) {
						exist[k] = true;
System.out.println("Yes (" + skyX + ", " + skyY + ")");
					}
						
				}
				
			}
			
		}
		
		return exist;
	}

	
	/*
	 * #1101 : Arithmetic Puzzles
	 */
	public static void arithmeticPuzzles(Scanner scanner) {
		int T = scanner.nextInt();
		for ( int i = 0; i < T; i++) {
			String puzzle = scanner.next();
			HashMap<Character, Integer> hmap = new HashMap<>();  // 存储字母数字的对应关系
			HashMap<Character, Boolean> notZero = new HashMap<>();  // 记录每个字母能否为零
			Boolean[] numUsed = new Boolean[10];  //  记录某个数字是否使用过了，初始为false
						
			// 找出所有字母，按字典序排列
			for (int j = 0; j < puzzle.length(); j++) {
				char ch = puzzle.charAt(j);
				if (ch >= 'A' && ch <= 'Z') {
					hmap.put(ch, -1);
				}				
			}
			
			// 预处理：不能为零的字母
			char ch = puzzle.charAt(0);
			notZero.put(ch, false);
			for (int j = 1; j < puzzle.length(); j++) {
				ch = puzzle.charAt(j);
				if (ch == '+' || ch == '=')
					notZero.put(puzzle.charAt(j + 1), false);
				else if (!notZero.containsKey(ch)) 
					notZero.put(ch, true);				
			}
// System.out.println(notZero);		
			

			// 枚举数字，分配和检查
			Set set = hmap.entrySet();
			Iterator iter = set.iterator();
			if (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				char letter = (char) entry.getKey();
				//DFS(letter, hmap, notZero, numUsed, iter);
			}
		
			// val[letter] = i
			//hmap.put(entry.getKey(), val);

		}
	}
	
	private static boolean DFS(char letter, HashMap<Character, Integer> hmap, 
			HashMap notZero, boolean[] numUsed, Iterator iter) {
		boolean boo = (boolean) notZero.get(letter);
		int startNum = boo ? 1 : 0;
		
		for (int i = startNum; i <= 9; i++) {
			if (!numUsed[i]) {
				numUsed[i] = true;
				hmap.put(letter, i);
				
				if (!iter.hasNext()) {
					if (check())
						return true;
				} else {
					Map.Entry entry = (Map.Entry) iter.next();
					char ch = (char) entry.getKey();
					if (DFS(ch, hmap, notZero, numUsed, iter))
						return true;
				}
				
				hmap.put(letter, -1);
				numUsed[i] = false;
			}
			
			return false;
		}
		return false;
	}
	
	private static boolean check() {
		
		return false;
	}
	
	
	/*
	 * #1102 : Individual Income Tax
	 */
	public static void incomeTax(Scanner scanner) {
		final int N = 6;
		int tax = scanner.nextInt();
		
		// 用数组记录分段点、税率、每个分段点对应的累计纳税值，
		int[] keyPoints = {0, 1500, 4500, 9000, 35000, 55000, 80000};
		double[] rates = {0, 0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45};
		int[] accumulatedTax = {0, 45, 345, 1245, 7745, 13745, 22495};	
			
		// 根据输入的 tax 值，找到对应的区间，查表计算
		int i = 0;
		while (i < N && tax > accumulatedTax[i + 1]) {
			i++;
		}
		
		int temp = tax - accumulatedTax[i];
		double base = keyPoints[i];
		double remnant = temp / rates[i + 1];
		int ret = (int) (base + remnant + 3500);
		
		System.out.println(ret);
	}
	

	/*
	 * #1103 : Colorful Lecture Note
	 */
	public static void colorNotes(Scanner scanner) {
		
		String[] splitWords = splitter(scanner);
		
		handle(splitWords);
	}
	
	// 对输入的字符串进行分词
	private static String[] splitter(Scanner scanner){
		String line = scanner.nextLine();
		ArrayList<String> wordsList = new ArrayList<>();		
		ArrayList<Integer> seperatorIndex = new ArrayList<>();
		
		int x = 0, y = 0;
		do {
			x = line.indexOf('<', y);
			y = line.indexOf('>', x);
			
			if (x != -1) {
				seperatorIndex.add(x);
				seperatorIndex.add(y);
			}
		} while (x != -1);
		
//StdOut.println(seperatorIndex);
		
		int N = seperatorIndex.size();
		String piece = line.substring(0, seperatorIndex.get(0));
		wordsList.add(piece);
		for (int i = 0; i < N - 1; i += 2) {
			piece = line.substring(seperatorIndex.get(i), 1 + seperatorIndex.get(i + 1));
			wordsList.add(piece.replaceAll("\\s", ""));  // 去空格		
			if (i + 2 < N) {
				piece = line.substring(1 + seperatorIndex.get(i + 1), seperatorIndex.get(i + 2));
				wordsList.add(piece.replaceAll("\\s", ""));
			}
		}
//StdOut.println(wordsList);

		String[] wordsArray = new String[wordsList.size()];
		return wordsList.toArray(wordsArray);
	}
	
	/*
	 * 处理lecture note——
	 * 1. 使用两个栈，分别存储标签和文本
	 * 2. 每逢 text: 入栈text；
	 *    逢<COLOR>: 出栈text, 入栈tags, 并考虑栈空以及 String red/yellow/blue的更新;
	 *    逢</COLOR>: 出栈tags, 也出栈text
	 */
	private static void handle(String[] splitWords) {
		String red = "", yellow = "", blue = "";
		Stack<String> tags = new Stack<>();
		Stack<String> text = new Stack<>();
		for (int i = 0; i < splitWords.length; i++) {
			String str = splitWords[i];
			
			if (!str.isEmpty()) {
				// text
				if (str.charAt(0) != '<') {
					text.push(str);
				}
				
				else {
					
					// tag <COLOR>
					if (str.charAt(1) != '/') {
						
						if (!text.isEmpty()) {
							if (!tags.isEmpty()) {
								char ch = tags.peek().charAt(1);
								switch (ch) {
								case 'r':
									red += text.pop();		break;
								case 'y':
									yellow += text.pop();	break;
								case 'b':
									blue += text.pop();		break;				
								}							
							} else {
								text.pop();  // 不带有标签的字符串，直接出栈
							}
														
						}
						
						tags.push(str);
					}
					
					// tag </COLOR>
					else {
						if (!text.isEmpty()) {
							char ch = tags.pop().charAt(1);
							switch (ch) {
							case 'r':
								red += text.pop();		break;
							case 'y':
								yellow += text.pop();	break;
							case 'b':
								blue += text.pop();		break;
							}						
						}
						
					}
					
				}		
			}

		}
		
System.out.println(red.length() + " " + yellow.length() + " " + blue.length());
	}

	
	/*
	 * #1092 : Have Lunch Together
	 */
 	public static void lunchTogether(Scanner scanner) {
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int startX = -1, startY = -1;
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = scanner.next();

			for (int j = 0; j < M; j++) {
				char ch = line.charAt(j);
				map[i][j] = ch;
				if (ch == 'H') {
					startX = i;
					startY = j;
				}
			}
		}

		
/* for (int i = 0; i < N; i++) StdOut.println(Arrays.toString(map[i]));
 StdOut.println(startX + ", " + startY);*/
		 

		int[][] step = BFS(map, N, M, startX, startY);

		chechAdjacentSeats(map, step, N, M);
	}

	public static int[][] BFS(char[][] map, int N, int M, int startX, int startY) {

		final int[][] direction = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // 左右上下
		ArrayList<Pair> seq = new ArrayList<Pair>();
		int[][] step = new int[N][M];

		seq.add(new Pair(startX, startY));
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				step[i][j] = Integer.MAX_VALUE;
		step[startX][startY] = 0;

		int i = 0;
		while (i < seq.size()) {
			for (int d = 0; d < 4; d++) {
				int curX = seq.get(i).first; // (5, 8)
				int curY = seq.get(i).second;
				int newX = curX + direction[d][0]; // (5, 7)
				int newY = curY + direction[d][1];

				if (availableInMap(newX, newY, map, N, M) && step[newX][newY] == Integer.MAX_VALUE) {
					step[newX][newY] = step[curX][curY] + 1;

					if (map[newX][newY] != 'S')
						seq.add(new Pair(newX, newY));
				}
			}

			i++;
		}

/*for (int t = 0; t < N; t++) {
	for (int v = 0; v < M; v++)
		StdOut.printf("%12d", step[t][v]);
	StdOut.println();
}*/

		return step;
	}

	private static boolean availableInMap(int x, int y, char[][] map, int N, int M) {
		return (x >= 0 && x < N && y >= 0 && y < M) && (map[x][y] == '.' || map[x][y] == 'S');
	}

	private static class Pair {
		int first, second;

		Pair(int f, int s) {
			first = f;
			second = s;
		}
	}

	
	public static void chechAdjacentSeats(char[][] map, int[][] step, int N, int M) {
		int ret = Integer.MAX_VALUE;
				
		for (int i = 1; i < N; i++)
			for (int j = 1; j < M; j++) {
				// 当前位置为 Seat，且可达
				if (map[i][j] == 'S' && step[i][j] != Integer.MAX_VALUE) {
					int current = step[i][j];
					int up = step[i - 1][j];
					int left = step[i][j - 1];

					// 检查上边
					if (i > 0) {
						if (map[i - 1][j] == 'S' && step[i - 1][j] != Integer.MAX_VALUE 
								&& ret > current + up) {
								ret = current + up;
// StdOut.println("(" + i + ", " + j + ") and up: " + ret);
							}						
					}

					// 检查左边
					if (j > 0) {
						if (map[i][j - 1] == 'S' && step[i][j - 1] != Integer.MAX_VALUE
								&& ret > current + left) {
								ret = current + left;
// StdOut.println("(" + i + ", " + j + ") and left: " + ret);						
					}

					}
/*					// 当前位置为(1, 1)时，还需额外检查(0, 0)
					if (i == 1 && j == 1 
						&& map[0][0] == 'S' && step[0][0] != Integer.MAX_VALUE 
						&& ret > current + step[0][0])
						ret = current + step[0][0];*/
					
				}
			}

		if (ret != Integer.MAX_VALUE)
			System.out.println(ret);
		else
			System.out.println("Hi and Ho will not have lunch.");
	}
	
		
	/*
	 * #1106 : Koch Snowflake
	 */
	public static int calc(int k, int n) {
		if (n == 0)
			return 0;

		int r = k % 4;
		if (r == 2 || r == 3)
			return n;

		if (r == 0)
			return calc(k / 4, n - 1);

		return calc(1 + k / 4, n - 1);
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		drinkingGame(scanner);

		scanner.close();
		

	}

}
