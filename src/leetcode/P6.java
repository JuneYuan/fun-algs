package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P6 {

	public String convert(String s, int numRows) {
		if (numRows == 1)	return s;
		int unitLen = 2 * (numRows - 1);
		double q = 1.0 * s.length() / unitLen;
		int unitNum = (int) Math.ceil(q);
		int lastUnitLen = s.length() % unitLen;
		// List[] ans = (ArrayList<Character>[]) new Object[numRows];
		List<List<Character>> ans = new ArrayList<List<Character>>(numRows);
		for (int i = 0; i < numRows; i++)
			ans.add(new ArrayList<Character>());

		for (int i = 0, bound1 = numRows, bound2 = numRows-2; i < unitNum; i++) {
			if (i == unitNum-1 && lastUnitLen != 0) {
				bound1 = Math.min(numRows, lastUnitLen);
				bound2 = Math.min(numRows-2, lastUnitLen-numRows);
			}
			for (int j = 0; j < bound1; j++) {
				int idx2 = i * unitLen + j;
				char ch = s.charAt(idx2);
				ans.get(j).add(ch);
//System.out.println(ch);
			}
			for (int k = 0; k < bound2; k++) {
				int idx2 = i * unitLen + numRows + k;
				char ch = s.charAt(idx2);
				ans.get(numRows-k-2).add(ch);
//System.out.println(ch);
			}
		}
		
		StringBuilder ret = new StringBuilder();
		for (int a = 0; a < numRows; a++) {
			for (Character ch : ans.get(a)) {
				System.out.print(ch);
				if (a == 0 || a == numRows-1)
					System.out.print(" ");
			}
			System.out.println();
		}
		
		for (List<Character> seq : ans) {
			//这里尝试把List类型的seq转成数组类型，可以的
			//但是String.valueof()方法不接受Character[]类型的参数
			//而将Character[]转为char[]，无方
			for (Character ch : seq) {
				ret.append(ch);			
			}
		}

		return ret.toString();
	}

	@Test
	public void test() {
		//String s = convert("YUANZHONGYANLI", 5);
		//String s = convert("AB", 2);
		//System.out.println(s);
		int a = 3, b = 5;
		double x = 1.0 * a / b;
		System.out.println(x);
	}

}
