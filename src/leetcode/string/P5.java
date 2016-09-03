package leetcode;

import org.junit.Test;

public class P5 {
    
    private boolean isPalindrome(String s, int st, int ed) {
        if (st < 0 || ed >= s.length())     return false;
        
        for (; st < ed; st++, ed--) {
            if (s.charAt(st) != s.charAt(ed))
                return false;
        }
        return true;
    }
    
    public String longestPalindrome(String s) {
        char[] aux = new char[2*s.length()-1];
        aux[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            aux[2*i-1] = '#';
            aux[2*i] = s.charAt(i);
        }
        s = String.valueOf(aux);
		String ret = s.substring(0, 1);
		int mxLen = 1;

		// 枚举子串的中间位置
		for (int md = 0; md < s.length(); md++) {
		    int r = (ret.length() - 1) / 2;
		    int left_bound = md - r;
		    int right_bound = md + r;
		    while (isPalindrome(s, left_bound, right_bound)) {
		    	left_bound--;
		    	right_bound++;
		    }
		    if (isPalindrome(s, ++left_bound, --right_bound)) {
    		    int len;
    		    if (s.charAt(left_bound) == '#')
    		        len = (right_bound - left_bound) / 2;
    		    else 
    		        len = (right_bound - left_bound) / 2 + 1;
    		    if (len > mxLen) {
		            ret = s.substring(left_bound, right_bound+1);
		            mxLen = len;
		        }
		    }
		}
		return ret.replace("#", "");
	}

	@Test
	public void test() {
		String s = "acacdas";
		System.out.println(longestPalindrome(s));
	}

}
