package problems.mathbits.leet.twice;

public class P136SingleNumber {

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0)     return -1;

        int ret = 0;

        for (int a : A) {
            ret ^= a;
        }

        return ret;
    }
}
