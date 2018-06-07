package lintcode1st.string;

public class P158 {
	public boolean anagram_hashmap(String s, String t) {
        if (s.isEmpty() || t.isEmpty())     return false;
        if (s.length() != t.length())       return false;
        
        int[] letterCnt = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            ++letterCnt[s.charAt(i)];
            --letterCnt[t.charAt(i)];
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (letterCnt[s.charAt(i)] != 0)
                return false;
        }
        
        return true;
    }
}
