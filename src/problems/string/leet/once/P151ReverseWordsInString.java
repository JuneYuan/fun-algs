package problems.string.leet.once;

public class P151ReverseWordsInString {

    /*public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        int idx = 0, pos = 0, len = 0;
        
        while (true) {
            while (idx < s.length() && s.charAt(idx) == ' ') {
                ++idx;
            }
            if (idx == s.length()) {
                break;
            }
            if (pos > 0) {
                ;
            }
            
            while (idx < s.length() && s.charAt(idx) != ' ') {
                ;
            }
            sb.reverse(pos, pos + len);
            pos += len;
            len = 0;
        }
        
        sb = sb.substring(0, pos);
        return sb.reverse();
    }*/

}
