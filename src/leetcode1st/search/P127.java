package leetcode1st.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class P127 {
	
    public int ladderLength(String beginWord, String endWord, Set<String> dict) {
        if (beginWord == null || endWord == null)   return 0;
        if (beginWord.length() == 0 && endWord.length() == 0)   return 0;
        assert(beginWord.length() == endWord.length());
        if (dict == null || dict.size() == 0)   return 0;
        
        int ladderLen = 1;
        dict.add(endWord);
        Queue<String> q = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        q.offer(beginWord);
        hash.add(beginWord);
        while (!q.isEmpty()) {
            ladderLen++;
            int qLen = q.size();
            while (qLen-- > 0) {
                String strTemp = q.poll();
                Set<String> possibleNextWords = getNextWords(strTemp, dict);
                for (String nextWord : possibleNextWords) {
                    if (nextWord.equals(endWord))   return ladderLen;
                    // filter visited dict word
                    if (hash.contains(nextWord))    continue;
                    q.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private Set<String> getNextWords(String curr, Set<String> dict) {
        Set<String> nextWords = new HashSet<>();
        for (int i = 0; i < curr.length(); i++) {
            char[] chars = curr.toCharArray();
System.out.println(chars);
            for (char c = 'a'; c <= 'z'; c++) {
            	if (c == curr.charAt(i)) {
System.out.printf("c == curr[%d] = %c\n", i, c);
            		continue;
            	}
           	
            	
                chars[i] = c;
                String temp = new String(chars);
                if (dict.contains(temp)) {
                    nextWords.add(temp);
                }
            }
        }
        
        return nextWords;
    }

    @Test
    public void test() {
    	String arg1 = "hot";
    	String arg2 = "dog";
    	Set<String> dict= new HashSet<>();
    	dict.add("hot");
    	dict.add("dog");
    	int ans = ladderLength(arg1, arg2, dict);
    	System.out.println(ans);
    }
}
