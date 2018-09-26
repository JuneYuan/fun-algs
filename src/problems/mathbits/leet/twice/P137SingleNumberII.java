package problems.mathbits.leet.twice;

public class P137SingleNumberII {

    public int singleNumber(int[] A) {
        int single = 0;

        final int INT_BITS = 32;
        for (int i = 0; i < INT_BITS; i++) {
            int bitSum = 0;
            for (int a : A) {
                bitSum += ((a >>> i) & 1);
            }

            single |= ((bitSum % 3) << i);

/*            // 若是从高位向低位计算二进制转十进制，可用如下代码
            single <<= 1;
            if ((bitSum % 3) != 0) {
                single += 1;
            }*/
        }

        return single;
    }

}
