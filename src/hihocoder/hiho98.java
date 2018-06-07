package hihocoder;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class hiho98 {
	private static final int M = 4;
	private static int[] num;
	
	private static boolean[] used;
	private static int[] nowNum;
	private static String[] ops;
	private static String[] opType = {"+", "-", "*", "/", "r-", "r/"};
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			num = new int[M];
			used = new boolean[M];
			nowNum = new int[M];
			ops = new String[M];
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < M; k++)
					num[k] = sc.nextInt();
				boolean ret = makeNum(0);
				System.out.println(ret ? "Yes" : "No");
			}
					
			
		}
	}

	private static boolean makeNum(int depth) {
		if (depth >= M)
			return makeOp(0);	// 枚举数字已完成，开始枚举运算符
		for (int i = 0; i < M; i++) {
			if (!used[i]) {
				nowNum[depth] = num[i];
				used[i] = true;
				if (makeNum(depth+1))
					return true;
				used[i] = false;
			}
		}
		return false;
	}

	private static boolean makeOp(int depth) {
		if (depth >= 3) {
			if (calType1() == 24)
				return true;
			if (calType2() == 24)
				return true;
			return false;
		}
		for (int i = 0; i < M; i++) {
			ops[depth] = opType[i];
			if (makeOp(depth + 1))
				return true;
		}
		return false;
	}

	private static int calType1() {
		String statement = String.format("( ( ( %d %s %d ) %s %d ) %s %d )", 
				nowNum[0], ops[0], nowNum[1], ops[1], nowNum[2], ops[2], nowNum[3]);
		return new Evaluate(statement).getRet();
	}
	
	private static int calType2() {
		String statement = String.format("( ( %d %s %d ) %s ( %d %s %d ) )",
				nowNum[0], ops[0], nowNum[1], ops[1], nowNum[2], ops[2], nowNum[3]);
		return new Evaluate(statement).getRet();
	}

}

class Evaluate {
	private String statement;
	private Scanner sc;
	
	Evaluate(String s) {
		statement = s;
		sc = new Scanner(statement);
	}
	
	public int getRet() {
		Deque<String> ops = new LinkedList<>();
		Deque<Integer> vals = new LinkedList<>();
		while (sc.hasNext()) {
			String s = sc.next();
			if (s.equals("("))	;
			else if (s.equals("+"))		ops.push(s);
			else if (s.equals("-"))		ops.push(s);
			else if (s.equals("*"))		ops.push(s);
			else if (s.equals("/"))		ops.push(s);
			else if (s.equals("sqrt"))	ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				int v = vals.pop();
				if (op.equals("+"))			v = vals.pop() + v;
				else if (op.equals("-"))	v = vals.pop() - v;
				else if (op.equals("*"))	v = vals.pop() * v;
				else if (op.equals("/"))	v = vals.pop() / v;
				else if (op.equals("r-"))	v = v - vals.pop();
				else if (op.equals("r/"))	v = v / vals.pop();
				vals.push(v);				
			}
			else	vals.push(Integer.parseInt(s));
		}
		return  vals.pop();
	}
}