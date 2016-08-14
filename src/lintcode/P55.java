package lintcode;

public class P55 {

    public boolean compareStrings(String A, String B) {
        if (A.length() < B.length())    return false;
        final int alphabetNum = 26;
        int[] letterCnt = new int[alphabetNum];
        for (int i = 0; i < A.length(); i++) {
            ++letterCnt[A.charAt(i) - 'A'];
        }
        
        for (int i = 0; i < B.length(); i++) {
            --letterCnt[B.charAt(i) - 'A'];
            if (letterCnt[B.charAt(i) - 'A'] < 0)   return false;
        }
        
        return true;
    }

}
