package leetcode1st.misc;

import org.junit.Test;

public class P7ReverseInteger {

	public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0)  return (-1 * reverse(-x));
        
        int ret = 0;
        for (int r; x > 0; x /= 10) {
            r = x % 10;
            if (ret > Integer.MAX_VALUE / 10)
                return 0;
            ret = ret * 10 + r;
        }
        return ret;		
	}

	public int reverse1(int x) {
		String str = String.valueOf(x);
		char[] rseq = new char[str.length()];

		int i = 0, j = str.length() - 1;
		if(x < 0) {
		    rseq[0] = '-';
		    i = 1;
		}
		for (; i <= j; i++, j--) {
			rseq[i] = str.charAt(j);
			rseq[j] = str.charAt(i);
		}

		String rstr = String.valueOf(rseq);
		try {
		    return Integer.parseInt(rstr);
		} catch (Exception e) {
		    return 0;
		}
		
	}

	@Test
	public void test() {
		//int x = -2147483648;
		int x = 2147483412;
		System.out.println(reverse(x));
	}
	
	@Test
	public void overflowTest() {
		int x = -2147483648;
		int y = -2147483647;
		System.out.println(-x);
		System.out.println(-y);
	}


}
