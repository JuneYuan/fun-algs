package problems.string.leet.twice;

import java.util.Arrays;

public class P242TwoStringsAreAnagrams {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)     return false;
        if (s.length() != t.length())   return false;

        int CHAR_SIZE = 256;
        int[] letterCnt = new int[CHAR_SIZE];
        for (int i = 0; i < s.length(); i++) {
            letterCnt[s.charAt(i)]++;
            letterCnt[t.charAt(i)]--;
        }

        for (int i = 0; i < CHAR_SIZE; i++) {
            if (letterCnt[i] != 0) {
                return false;
            }
        }

        return true;
    }

}

class SolutionII {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)     return false;
        if (s.length() != t.length())   return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }

}
