package lintcode1st.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P171 {
	public List<String> anagrams(String[] strs) {
		if (strs.length < 2)	return Arrays.asList(strs);
		
		List<String> result = new ArrayList<>();
		boolean[] visited = new boolean[strs.length];
		for (int i = 0; i < strs.length; i++) {
			boolean hasAnagram = false;
			for (int j = i + 1; j < strs.length; j++) {
				if (!visited[j] && isAnagram(strs[i], strs[j])) {
					result.add(strs[j]);
					visited[j] = true;
					hasAnagram = true;
				}
			}
			
			if (!visited[i] && hasAnagram) {
				result.add(strs[i]);
			}
		}
		
		return result;
	}

	private static boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;
		
		final int  AlphabetNum = 26;
		int[] letterCnt = new int[AlphabetNum];
		for (int i = 0; i < s.length(); i++) {
			++letterCnt[s.charAt(i) - 'a'];
			--letterCnt[t.charAt(i) - 'a'];
		}
		
		for (int i = 0; i < t.length(); i++) {
			if (letterCnt[t.charAt(i) - 'a'] != 0)
				return false;
		}
		
		return true;
	}
}
