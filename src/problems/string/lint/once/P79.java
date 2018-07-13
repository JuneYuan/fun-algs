package lintcode1st.string;

public class P79 {
	public int longestCommonSubstring(String A, String B) {
		if (A == null || A.length() == 0 || B == null || B.length() == 0) {
			return 0;
		}
		
		int lcs = 0;
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				int lcsTemp = 0;
				while (i + lcsTemp < A.length() 
						&& j + lcsTemp < B.length()
						&& A.charAt(i + lcsTemp) == B.charAt(j + lcsTemp)) {
					lcsTemp++;
				}
				
				// update lcs
				if (lcsTemp > lcs) {
					lcs = lcsTemp;
				}
			}
		}
		
		return lcs;
	}
}
