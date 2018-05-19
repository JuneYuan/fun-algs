package leetcode1st.string;

import org.junit.Test;

public class P28 {

    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            String test = haystack.substring(i, i + len2);
            //System.out.println(test);
            if (test.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
	
	@Test
	public void test() {
		String s = "hello";
		String ss = s.substring(0, 0);
		System.out.println(ss);
	}
}
