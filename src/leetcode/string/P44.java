package leetcode.string;

public class P44 {
	
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)	return false;
		if (s.length() == 0 || p.length() == 0)	return false;
		
		return helper(s, 0, p, 0);
	}
	
	// 这个函数的输入：为待匹配串、模式串、和待比较位置的索引
	// 输出为：匹配结果
	private boolean helper(String s, int si, String p, int pj) {
		if(si == s.length() || pj == p.length()) {
			if (si == s.length() && pj == p.length()) {
				return true;
			} else {
				return false;
			}
		}
		
		if (p.charAt(pj) == '*') {
			// 如果p中字符为'*'，s应尽可能向前推进
			
			// remove continuous *
			while (p.charAt(pj) == '*') {
				pj++;
				if (pj == p.length())	return true;
			}
			
			// compare s with remaining part of p after *
			while (si < s.length() && !helper(s, si, p, pj)) {
				si++;
			}
			// substring of p equals to s
			return si != s.length();		
		} else if (s.charAt(si) == p.charAt(pj) || p.charAt(pj) == '?') {
			// 如果是普通字符，或p中字符为'?'，两个字符串索引向前推进一位即可
			return helper(s, si + 1, p, pj + 1);
		} else {
			return false;
		}
	}
}
