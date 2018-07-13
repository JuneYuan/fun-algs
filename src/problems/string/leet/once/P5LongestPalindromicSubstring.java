package leetcode1st.string;

public class P5LongestPalindromicSubstring {
	
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String t = palindrome(s, i, i);  // longest palindrome centered i
            if (t.length() > res.length())
                res = t;
            
            t = palindrome(s, i, i+1);  // longest palindrome centered i and i+1
            if (t.length() > res.length())
                res = t;
        }
        return res;
    }
    
    private String palindrome(String s, int l, int r) {
        // expand as long as it is still palindrome
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //System.out.println(s + "..." + s.substring(l+1, r));
        return s.substring(l+1, r);
    }
}
