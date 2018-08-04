package problems.misc.leet;

import org.junit.Test;

public class P8StringToInteger {
	public int atoi(String str) {
		if (str == null || str.length() == 0)	return 0;
		
		// trim leading and trailling spaces
		String strTrim = str.trim();
		
		int sign = 1;  // symbol + or -
		int i = 0;
		if (strTrim.charAt(i) == '+') {
			i++;
		} else if (strTrim.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		
		// store the result as LONG to avoid overflow
		long ans = 0;
		while (i < strTrim.length()) {
			if (strTrim.charAt(i) < '0' || strTrim.charAt(i) > '9') 
				break;
			ans = 10 * ans + sign * (strTrim.charAt(i) - '0');
			//overflow
			if (ans > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (ans < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			i++;
		}
		return (int)ans;
	}

	@Test
	public void test() {
		String str = "   abc def  ";
		String strTrim = str.trim();
		String[] substr = str.split("\\s+");
		for (String s : substr)
			System.out.println(s);
/*		System.out.println(str.split("\\s+")[1]);
		System.out.println(str.split("\\s+")[2]);*/
	}
	
	@Test
	public void test2() {
		//测试未占满长度的字符数组，取String.valueOf后的结果
		char[] seq = new char[10];
/*		seq[0] = 'h';
		seq[1] = 'f';*/
		String str1 = String.valueOf(seq);
		String str2 = String.valueOf(seq).trim();
		long ans = Long.parseLong(str2);
	}
}
