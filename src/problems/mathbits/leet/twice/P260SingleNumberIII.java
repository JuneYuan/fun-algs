package problems.mathbits.leet.twice;

public class P260SingleNumberIII {

    public int[] singleNumber(int[] A) {
        int[] ret = new int[2];

        if (A == null || A.length == 0)     return ret;

        int xor = 0;
        for (int a : A) {
            xor ^= a;
        }

        // get the last 1 bit of xor, e.gl 1010 ==> 0010
        int last1Bit = xor - (xor & (xor - 1));
        int single1 = 0, single2 = 0;
        for (int a : A) {
            if ((last1Bit & a) == 0) {
                single1 ^= a;
            } else {
                single2 ^= a;
            }
        }

        ret[0] = single1;
        ret[1] = single2;
        return ret;
    }

}
