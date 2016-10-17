package exam;

/*
压缩字符串，类似 LeetCode 的 CountAndSay 那题
 */
public class Zenjoy1_zipString {
	public String zipString(String s) {
		if (s == null || s.length() == 1)	return s;
		
		StringBuilder result = new StringBuilder();
		int cnt = 1, i = 0;
		for (i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i + 1) == s.charAt(i)) {  // expand
				cnt++;
			} else {
				if (cnt == 1) {  // no-repeat
					result.append(s.charAt(i));
				} else {  // no longer repeat
					result.append(cnt);
					result.append(s.charAt(i));
					cnt = 1;
				}
			}			
		}
		
		if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
			result.append(cnt);
		}
		result.append(s.charAt(i));
		
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Zenjoy1_zipString().zipString("abcbc"));
		System.out.println(new Zenjoy1_zipString().zipString("xxxyyyyyyz"));
	}
}
