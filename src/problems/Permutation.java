package problems;

public class Permutation {
	
	private static void permutation1(String str, String ret) {
		System.out.println(ret);
		int len = str.length();
		if (ret.length() == len)
			System.out.println("..."+ret);
		else {
			for (int i = 0; i < len; i++) {
				char ch = str.charAt(i);
				if (ret.indexOf(ch) < 0)
					permutation1(str, ret+ch);
			}
		}
	}

	public static void main(String[] args) {
		String s = "abcd";
		String result = "";
		permutation1(s, result);
	}

}
