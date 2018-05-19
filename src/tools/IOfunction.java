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
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;

public class IOfunction {
	
	/*
	 * #1136 : Professor Q's Software
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
			sig = new Signal(val);
			modules[0].sendSignal.add(sig);			
			signalPool.put(val, sig);
		}
		
		// 读取其他 module 信息
		for (int i = 1; i <= N; i++) {
			val = in.nextInt();	
			sig = signalPool.get(val);
			if (sig == null)
				sig = new Signal(val);
			signalPool.put(val, sig);
			
			// 维护 Module.activeSignal, Signal.canActiveModule 信息
			modules[i].id = i;
			modules[i].activeSignal = sig;
			sig.canActiveModule.add(modules[i]);
						
			// 维护 Module.sendSignal 信息
			num = in.nextInt();
			for (int j = 1; j <= num; j++) {
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
		
		// 找入度零的点，即起点
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
			Module moduI = seqMap.get(i);
			for (int j : edgeInfo[i]) {				
				Module moduJ = modules[j];
				moduJ.activeCount += moduI.activeCount;
				moduJ.inDegree -= 1;  // ???
				if (moduJ.inDegree == 0) {	
					seqMap.put(tail, moduJ);
					tail += 1;
				}
			}
			
			i++;
		}
	}
	
	private static void output(PrintWriter out) {
		for (int i = 1; i < modules.length; i++ ) {
			out.print(modules[i].activeCount + " ");
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
	
	static class InputReader {
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