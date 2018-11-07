package problems.search.leet.twice;

import java.util.ArrayList;
import java.util.List;

public class P60PermutationSequence {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();

        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            fact *= i;
        }

        for (int i = n; i >= 1; i--) {
            fact /= i;
            int rank = (k-1) / fact;
            k = (k-1) % fact + 1;
            sb.append(nums.get(rank));
            nums.remove(rank);
        }

        return sb.toString();
    }

}
