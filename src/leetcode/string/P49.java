package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49 {

	public List<List<String>> groupAnagrams_nLlogL(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (strs.length < 2) {
			result.add(Arrays.asList(strs));
			return result;
		}
		
		Map<String, ArrayList<String>> multiMap = new HashMap<>();
		for (String str : strs) {
			char[] strChar = str.toCharArray();
			Arrays.sort(strChar);
			String strSorted = String.valueOf(strChar);
			// append if already exist; or create if not int the map yet
			if (multiMap.containsKey(strSorted)) {
				ArrayList<String> aList = multiMap.get(strSorted);
				aList.add(str);
			} else {
				ArrayList<String> aList = new ArrayList<>();
				aList.add(str);
				multiMap.put(strSorted, aList);
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

}
