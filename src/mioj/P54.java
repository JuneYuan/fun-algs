package mioj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P54 {
	private static String solution(String line) {
	    // 在此处理单行数据
	    boolean judge = true;
	    
	    line = line.replaceAll(",", "").replaceAll(" ", "");
	    char[][] board = new char[9][9];
	    for (int i = 0; i < line.length(); i++) {
	    		int baseI = (i / 9) / 3 * 3;
	    		int baseJ = (i / 9) % 3 * 3;
	    		int deltaI = (i % 9) / 3;
	    		int deltaJ = (i % 9) % 3;
	        board[baseI + deltaI][baseJ + deltaJ] = line.charAt(i);
	    }
	    
	    HashMap<Integer, Set<Character>> rowMonitor = new HashMap<Integer, Set<Character>>();
	    HashMap<Integer, Set<Character>> colMonitor = new HashMap<Integer, Set<Character>>();
	    HashMap<Integer, Set<Character>> blockMonitor = new HashMap<Integer, Set<Character>>();
	    for (int k = 0; k < 9; k++) {
	        rowMonitor.put(k, new HashSet<Character>());
	        colMonitor.put(k, new HashSet<Character>());
	        blockMonitor.put(k, new HashSet<Character>());
	    }
	        
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            char ch = board[i][j];
	            // TODO: wants better condition
	            if (ch < '0' || ch > '9')  continue;
	            
	            boolean rowJudgeFail = rowMonitor.get(i).contains(ch);
	            boolean colJudgeFail = colMonitor.get(i).contains(ch);
	            boolean blockJudgeFail = blockMonitor.get(i).contains(ch);
	            if (rowJudgeFail || colJudgeFail || blockJudgeFail) {
	            		judge = false;
	            		break;
	            }
	            rowMonitor.get(i).add(ch);
	            colMonitor.get(i).add(ch);
	            blockMonitor.get(i).add(ch);
	        }
	        if (!judge)  break;
	    }
	    // 返回处理后的结果
	    return Boolean.toString(judge);
	}

	public static void main(String[] args) {
		String line = "5,3,-,6,-,-,-,9,8 -,7,-,1,9,5,-,-,- -,-,-,-,-,-,-,6,- 8,-,-,4,-,-,7,-,- -,6,-,8,-,3,-,2,- -,-,3,-,-,1,-,-,6 -,6,-,-,-,-,-,-,- -,-,-,4,1,9,-,8,- 2,8,-,-,-,5,-,7,9";
		String line1 = "5,3,-,6,-,-,-,9,8 -,7,-,1,9,5,-,-,- -,-,-,-,-,-,-,6,- 8,-,-,4,-,-,7,-,- -,6,-,8,-,3,-,2,- -,-,3,-,-,1,-,-,6 -,6,-,-,-,-,-,9,- -,-,-,4,1,9,-,8,- 2,8,-,-,-,5,-,7,9";
		System.out.println(solution(line));
		System.out.println(solution(line1));
	}
}
