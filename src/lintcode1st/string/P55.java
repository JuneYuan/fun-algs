package lintcode1st.string;

public class P55 {

    public boolean compareStrings(String A, String B) {
        if (A == null || B == null)     return false;
        if (A.length() < B.length())    return false;
        
        final int UPPER_NUM = 26;
        int[] letterCnt = new int[UPPER_NUM];
        
        for (int i = 0; i < A.length(); i++) {
            ++letterCnt[A.charAt(i) - 'A'];
        }
        
        for (int i = 0; i < B.length(); i++) {
            int idx = B.charAt(i) - 'A';
            --letterCnt[idx];
            if (letterCnt[idx] < 0)    return false;
        }
        
        return true;
    }

}
