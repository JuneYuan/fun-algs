import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;

public class Main {
	
	/*
	 * #1032 : 最长回文子串
	 */
	private static int N, L;
	private static String inputStr, handledStr, Ret;
	private static String[] f;
	private static int[] helper;
	
	public static void palindromeSubStr(Scanner scanner) {
		N = scanner.nextInt();
		for (int i = 0, j = 0; i < N; i++) {
			inputStr = scanner.next();
			handledStr = new String();
			L = inputStr.length();
			Ret = inputStr.substring(0, 1);
			f = new String[2 * L - 1];
			helper = new int[2 * L - 1];
			
			for (int t = 1; t <= L; t++) {
				handledStr += inputStr.substring(t - 1, t);
				if (t < L)
					handledStr += "@";
			}
			
			for (int t = 0; t < f.length; t++) {
				f[t] = handledStr.substring(t, t + 1);
				helper[t] = 1;
			}			
			
			// 枚举中心位置
			for (int midIdx = 1; midIdx < handledStr.length() - 1; midIdx++) {
				f[midIdx] = "";
				String subStr;
				int span = midIdx < handledStr.length() / 2 ? midIdx : handledStr.length() - 1 - midIdx;
				
				// 找出 f(midIdx) 的最小值，或者是 k 的循环初始值
				int t = 2 * j - midIdx;
				if (t >= 0 && t < helper.length) {
					int c = helper[t];
					int d = helper[j] - 2 * (midIdx - j);
					j = c < d ? c : d;
					j = j < 1 ? 1 : j;
					j = j > span ? span : j;
				}
				
				for (int k = j; k <= span; k++) {
					char x = handledStr.charAt(midIdx - k);
					char y = handledStr.charAt(midIdx + k);
					subStr = handledStr.substring(midIdx - k, midIdx + k + 1);
					subStr = subStr.replaceAll("@", "");
					if (x == y && f[midIdx].length() <= subStr.length())
						f[midIdx] = subStr;
					else
						break;
				}
				
				// 找出使其右边界 j + f(j) / 2 最大的 j
				helper[midIdx] = f[midIdx].length();
				int a = midIdx + helper[midIdx] / 2;
				int b = midIdx - 1 + helper[midIdx - 1] / 2;
				if (a > b) {
					j = midIdx;
				}
				
				if (f[midIdx].length() > Ret.length()) {
					Ret = f[midIdx];
				}

				
	
			}
			
			System.out.println(Ret);
		}
	}
	
	/*
	 * #1136 : Professor Q's Software 未完成❌
	 */
	private static int T, N, M;
	private static HashMap<Integer, Signal> signalPool;
	private static Module[] modules;
	private static Collection<Integer>[] edgeInfo;
		
	public static void startSoftware(InputReader in, PrintWriter out) {
		T = in.nextInt();						
		for (int t = 0; t < T; t++) {
			getInput(in);		
			makeGraph();
	
System.out.printf("\nT=%d\n", t);			
for (int i = 0; i <= N; i++)
	System.out.printf("模块 %d 可启动模块 %s\n", i, edgeInfo[i]);			
			
			// 进行拓扑排序
			toposort();
			
			// 深度优先搜索
			//DFS(modules[0], 0);
			
			output(out);
		}
	}

	@SuppressWarnings("unchecked")
	private static void getInput(InputReader in) {
		N = in.nextInt();  // 模块数
		M = in.nextInt();	// 初始信号数
		
		signalPool = new HashMap<>();
		modules = new Module[N + 1];
		edgeInfo = (Vector<Integer>[]) new Vector[N + 1];
		for (int i = 0; i <= N; i++) {
			modules[i] = new Module();
			edgeInfo[i] = new Vector<Integer>();
		}
		
		Signal sig;
		int val, num;
		// 读取初始数据流，作为 module0
		modules[0].id = 0;
		for (int i = 0; i < M; i++) {
			val = in.nextInt();
			sig = signalPool.get(val);
			if (sig == null) {
				sig = new Signal(val);
				signalPool.put(val, sig);
			}
			modules[0].sendSignal.add(sig);
		}
		
		// 读取其他 module 信息
		for (int i = 1; i <= N; i++) {
			val = in.nextInt();	
			sig = signalPool.get(val);
			if (sig == null) {
				sig = new Signal(val);
				signalPool.put(val, sig);
			}
			
			// 维护 Module.activeSignal, Signal.canActiveModule 信息
			modules[i].id = i;
			modules[i].activeSignal = sig;
			sig.canActiveModule.add(modules[i]);
						
			// 维护 Module.sendSignal 信息
			num = in.nextInt();
			for (int j = 0; j < num; j++) {
				val = in.nextInt();			
				sig = signalPool.get(val);
				if (sig == null) {
					sig = new Signal(val);
					signalPool.put(val, sig);
				}
					
				modules[i].sendSignal.add(sig);				
			}
		}		
	}
	
	private static void makeGraph() {
		/* 顺序遍历输入的modules[]信息，构造有向无环图
		 * 并在构造图的同时，统计入度
		 */		
		for (int i = 0; i <= N; i++) {
			for (Signal sign : modules[i].sendSignal) {
				for (Module modu : sign.canActiveModule) {
					addEdge(i, modu.id);						
					modu.inDegree += 1;						
				}
			}
		}
	}
	
	private static void addEdge(int v, int w){
		edgeInfo[v].add(w);
	}
	
	private static void toposort() {
		int tail = 0;
		Map<Integer, Module> seqMap = new TreeMap<>();
		
		// 找入度零的点（可能不只是起点）
		for (int i = 0; i <= N; i++) {
			Module moduI = modules[i];
			if (moduI.inDegree == 0) {
				seqMap.put(tail, moduI);
				tail++;
			}
		}
		
		modules[0].activeCount = 1;  // 设置模块0的访问次数为1
		int i = 0;
		while (i < tail) {
			
System.out.println("\ni=" + i + " < " + tail + "=tail");

			Module moduI = seqMap.get(i);
			for (int j : edgeInfo[i]) {	
				
System.out.println("    j=" + j);	
				
				Module moduJ = modules[j];
				moduJ.activeCount += moduI.activeCount % 142857;
				moduJ.activeCount = moduJ.activeCount % 142857;
				moduJ.inDegree -= 1;  // ???
			
System.out.printf("        modules[%d].activeCount=%d\n", j, moduJ.activeCount);				
System.out.printf("        modules[%d].inDegree=%d\n", j, moduJ.inDegree);	
			
				if (moduJ.inDegree == 0) {	
					seqMap.put(tail, moduJ);
					tail += 1;
					
System.out.printf("        modules[%d].inDegree==0\n", j);
System.out.printf("            seqMap=%s\n", seqMap.toString());
System.out.printf("            tail=%d\n", tail);
				
				}
			}
			
			i++;
		}
	}
	
	private static void output(PrintWriter out) {
		for (int i = 1; i < modules.length; i++ ) {
			int r = modules[i].activeCount % 142857;
			out.print(r + " ");
		}
		out.println();
	}
	
	private static class Module {
		int id = -1;
		int inDegree = 0;
		int activeCount = 0;
		Signal activeSignal = new Signal(-1);
		ArrayList<Signal> sendSignal = new ArrayList<>();		
		
		public String toString() {
			return ("modules[" + id + "]");
			//return (activeSignal + ", " + sendSignal);
		}
	}
	
	private static class Signal {
		int val;
		List<Module> canActiveModule = new ArrayList<>();
		//List<Integer> canActiveModule = new ArrayList<>();
		
		Signal(int val) {
			this.val = val;
		}
		
		public String toString() {
			//return Integer.toString(val);
			return (val + "/" + canActiveModule.toString());
		}
	}
	
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		
		startSoftware(in, out);	
		
		out.close();
	}
	
	private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}