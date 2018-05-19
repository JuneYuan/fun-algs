package leetcode1st.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class P49_1 {
	// Solution 1
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		
		for (String word : strs) {
			boolean groupExists = false;
			for (List<String> group : result) {
				if (isAnagram(word, group.get(0))) {
					group.add(word);
					groupExists = true;
					break;
				}
			}
			
			if (!groupExists) {
				List<String> newGroup = new ArrayList<String>();
				newGroup.add(word);
				result.add(newGroup);
			}
		}
		
		return result;
	}
	
	private static boolean isAnagram(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) 
			return false;
		
		int NUM = 26;
		int[] letterCnt = new int[NUM];
		for (int i = 0; i < a.length(); i++) {
			++letterCnt[a.charAt(i) - 'a'];
			--letterCnt[b.charAt(i) - 'a'];
		}
		
		for (int i = 0; i < NUM; i++) {
			if (letterCnt[i] != 0)	return false;
		}
		
		return true;
	}

	// Solution 2
	public List<List<String>> groupAnagrams_n2L(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs == null)	return result;
		
		Map<String, ArrayList<String>> multiMap = new HashMap<>();
		for (String str : strs) {
			char[] strChar = str.toCharArray();
			Arrays.sort(strChar);
			String strSorted = String.valueOf(strChar);
			if (multiMap.containsKey(strSorted)) {
				ArrayList<String> group = multiMap.get(strSorted);
				group.add(str);
				multiMap.put(strSorted, group);
			} else {
				ArrayList<String> group = new ArrayList<>();
				group.add(str);
				multiMap.put(strSorted, group);
			}
		}
		
		Set<String> keySet = multiMap.keySet();
		for (String key : keySet) {
			ArrayList<String> aList = multiMap.get(key);
			Collections.sort(aList);
			result.add(aList);
		}
		
		return result;
	}
	
	@Test
	public void test() {
		String[] dict = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(dict);
		for (List<String> group : result) {
			System.out.println(group);
		}
	}

}
