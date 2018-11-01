package problems.string.leet.twice;

public class P151ReverseWordsInString {

    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }

        return sb.toString();
        //return sb.substring(0, sb.length() - 1);
    }

}
