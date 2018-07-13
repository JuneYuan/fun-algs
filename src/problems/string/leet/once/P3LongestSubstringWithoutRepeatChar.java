package leetcode1st.string;

import java.util.Hashtable;

import org.junit.Test;

public class P3LongestSubstringWithoutRepeatChar {

	public int lengthOfLongestSubstring(String s) {
		Hashtable<Character, Integer> hash = new Hashtable<>(); // 记录某字符上次出现时对应的下标
		int mxLen = 1;
		int start = 0, end = 1;

		if (s.length() == 0)
			return 0;

		hash.put(s.charAt(0), 0);
		while (end < s.length()) {
			Integer lastPos = hash.get(s.charAt(end));
			if (lastPos != null && lastPos >= start) {
				start = lastPos + 1;
			}
			mxLen = Math.max(mxLen, end - start + 1);
			hash.put(s.charAt(end), end);
			end++;
		}

		return mxLen;
	}

	@Test
	public void test() {
		lengthOfLongestSubstring("pwwkew");
	}

}
