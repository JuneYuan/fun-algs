package problems.string.leet.twice;

import java.util.ArrayList;
import java.util.List;

public class P842SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();

        int n = S.length();
        for (int len0 = 1; len0 < S.length(); len0++) {
            for (int len1 = 1; len1 < S.length(); len1++) {
                if (len0 + len1 >= n)               break;
                int len2 = n - len0 - len1;
                if (len2 < Math.max(len0, len1))    break;

                result = helper(len0, len1, S);
                if (!result.isEmpty()) {
                    return result;
                }
            }
        }

        return result;
    }

    private List<Integer> helper(int len0, int len1, String S) {
        List<Integer> result = new ArrayList<>();
        String s0 = S.substring(0, len0), s1 = S.substring(len0, len0 + len1);

        if (!isValidNum(s0) || !isValidNum(s1)) {
            return result;
        }

        result.add(Integer.valueOf(s0));
        result.add(Integer.valueOf(s1));

        StringBuilder FiboS = new StringBuilder(s0 + s1);
        boolean shorterThanS = true;
        boolean currMatch = true;
        boolean sumIsValid = true;
        do {
            int sum = trySum(s0, s1);

            if (sum == -1) {
                sumIsValid = false;
                break;
            }

            // update s0, s1
            s0 = s1;
            s1 = Long.toString(sum);

            // update Fibos, result
            FiboS.append(s1);
            result.add(sum);

            if (FiboS.length() < S.length()) {
                currMatch = S.startsWith(FiboS.toString());
            } else {
                shorterThanS = false;
            }
        } while (shorterThanS && currMatch);

        if (!sumIsValid || !currMatch || !FiboS.toString().equals(S)) {
            result.clear();
            return result;
        }

        return result;
    }

    private boolean isValidNum(String s) {
        // forbid leading 0
        char CH_ZERO = '0';
        if (s.length() > 1 && s.charAt(0) == CH_ZERO) {
            return false;
        }

        // forbid greater than max int
        if (Integer.MAX_VALUE - Long.valueOf(s) < 0) {
            return false;
        }

        return true;
    }

    private int trySum(String s0, String s1) {
        if (!isValidNum(s0) || !isValidNum(s1)) {
            return -1;
        }

        Long sum = Long.valueOf(s0) + Long.valueOf(s1);
        if (sum > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) ((long) sum);
    }

    public static void main(String[] args) {
        P842SplitArrayIntoFibonacciSequence obj = new P842SplitArrayIntoFibonacciSequence();
        int len0 = 3, len1 = 1;
//        String S = "37101727";
        String S = "214748364721474836422147483641";
        System.out.println(obj.splitIntoFibonacci(S));
    }


}
