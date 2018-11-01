package problems.string.leet.twice;

public class P58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;

        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && len == 0) {
                continue;
            } else if (s.charAt(i) == ' ' && len > 0) {
                return len;
            } else {
                len++;
            }
        }

        return len;
    }

}
