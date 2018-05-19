package leetcode1st.string;

import java.util.Arrays;

public class P87 {

	// Recursive
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
        	return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
        	return true;
        }
        
        if (!isValid(s1, s2)) {
        	return false;
        }	// Base cases
        
        int N = s1.length();
        for (int i = 1; i < N; i++) {
        	String s11 = s1.substring(0, i);
        	String s12 = s1.substring(i, N);
        	String s21 = s2.substring(0, i);
        	String s22 = s2.substring(i, N);
        	String s23 = s2.substring(0, i);
        	String s24 = s2.substring(i, N);
        	
        	if (isScramble(s11, s21) && isScramble(s12, s22)) {
        		return true;
        	}
        	if (isScramble(s11, s24) && isScramble(s12, s23)) {
        		return true;
        	}	// cut     	
        }
        
    	return false;   
    }

    private boolean isValid(String s1, String s2) {
    	char[] chSeq1 = s1.toCharArray();
    	char[] chSeq2 = s1.toCharArray();
    	Arrays.sort(chSeq1);
    	Arrays.sort(chSeq2);
    	if (!(new String(chSeq1)).equals(new String(chSeq2))) {
    		return false;
    	}
    	
    	return true;
    }
}
