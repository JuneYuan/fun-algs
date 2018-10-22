package problems.string.leet.twice;

import java.util.*;

public class P49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i])     continue;

            List<String> gr = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && beAnagrams(strs[i], strs[j])) {
                    gr.add(strs[j]);
                    visited[j] = true;
                }
            }

            gr.add(strs[i]);
            visited[i] = true;
            ret.add(gr);
        }

        return ret;
    }

    private boolean beAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null)   return false;
        if (s1.length() != s2.length())     return false;

        int SIZE = 26;
        int[] letterCnt = new int[SIZE];

        for (int i = 0; i < s1.length(); i++) {
            letterCnt[s1.charAt(i) - 'a']++;
            letterCnt[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < SIZE; i++) {
            if (letterCnt[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        new P49GroupAnagrams().groupAnagrams(strs);
    }

}

class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();

        if (strs == null || strs.length == 0)   return ret;

        // one key to multiple value multiMap
        Map<String, ArrayList<String>> multiMap = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sortedS = String.valueOf(chs);
            if (multiMap.containsKey(sortedS)) {
                ArrayList<String> list = multiMap.get(sortedS);
                list.add(s);
                multiMap.put(sortedS, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                multiMap.put(sortedS, list);
            }
        }

        // add List group to ret
        Set<String> keySet = multiMap.keySet();
        for (String key : keySet) {
            ret.add(multiMap.get(key));
        }

        return ret;
    }

}