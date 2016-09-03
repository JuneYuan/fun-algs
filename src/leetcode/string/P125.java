package leetcode;

public class P125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())   return true;
        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while (l < r) {
            char chL = s.charAt(l);
            char chR = s.charAt(r); 
            if (Character.isLetterOrDigit(chL) && Character.isLetterOrDigit(chR)) {
                if (Character.toLowerCase(chL) != Character.toLowerCase(chR)) {
                    return false;
                }
                l++;
                r--;
            } else {
                if (!Character.isLetterOrDigit(chL))    l++;
                if (!Character.isLetterOrDigit(chR))    r--;
            }
        }
        return true;
    }

}
