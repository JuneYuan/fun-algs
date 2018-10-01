package problems.mathbits.lint.twice;

public class P181FlitBits {

    public int bitSwapRequired(int a, int b) {
        int count = 0;
        int aXORb = a ^ b;
        while (aXORb != 0) {
            count++;
            aXORb &= (aXORb - 1);
        }

        return count;
    }

}
