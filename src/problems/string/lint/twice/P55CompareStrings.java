package problems.string.lint.twice;

public class P55CompareStrings {

    public boolean compareStrings(String A, String B) {
        if (A == null || B == null)     return false;
        if (A.length() < B.length())    return false;

        int LETTER_CNT = 26;
        int[] charHash = new int[LETTER_CNT];
        for (int i = 0; i < A.length(); i++) {
            charHash[A.charAt(i) - 'A']++;
        }

        for (int i = 0; i < B.length(); i++) {
            charHash[B.charAt(i) - 'A']--;
            if (charHash[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }

        return true;
    }

}
