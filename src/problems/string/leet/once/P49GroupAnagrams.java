package leetcode1st.string;

import org.junit.Test;

import java.util.*;

public class P49GroupAnagrams {

	/**
	 *
	 */
	public List<List<String>> groupAnagrams_nLlogL(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (strs == null || strs.length < 2) {
			result.add(Arrays.asList(strs));
			return result;
		}
		
		// one key(word) to multiple value(anagrams) map
		Map<String, ArrayList<String>> multiMap = new HashMap<>();
		for (String str : strs) {
			char[] strChar = str.toCharArray();
			Arrays.sort(strChar);
			String strSorted = String.valueOf(strChar);
			// append if already exist; or create if not int the map yet
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
		
		// add List group to result
		result.addAll(multiMap.values());
			
		return result;
	}
	
    public List<List<String>> groupAnagrams_Ln2(String[] strs) {
    	List<List<String>> result = new ArrayList<>();
    	if (strs.length < 2) {
    		result.add(Arrays.asList(strs));
    		return result;
    	}
    	
    	boolean[] visited = new boolean[strs.length];
    	for (int s1 = 0; s1 < strs.length; s1++) {
    		List<String> group = new ArrayList<>();
    		for (int s2 = s1+1; s2 < strs.length; s2++) {
    			if (!visited[s2] && isAnagrams(strs[s1], strs[s2])) {
    				group.add(strs[s2]);
    				visited[s2] = true;
    			}
    		}
    		if (!visited[s1]) {
    			group.add(strs[s1]);
    			visited[s1] = true;
    		}
    		if (group.size() > 0)
    			result.add(group);
    	}
    		
        return result;
    }
    
    private boolean isAnagrams(String s, String t) {
    	if (s.length() != t.length())
    		return false;
    	final int alphabetNum = 26;
    	int[] letterCount = new int[alphabetNum];
    	for (int i = 0; i < s.length(); i++) {
    		++letterCount[s.charAt(i) - 'a'];
    		--letterCount[t.charAt(i) - 'a'];
    	}
    	for (int i = 0; i < letterCount.length; i++) {
    		if (letterCount[i] != 0)
    			return false;
    	}
    	
    	return true;
    }


	/**
	 *
	 */
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
