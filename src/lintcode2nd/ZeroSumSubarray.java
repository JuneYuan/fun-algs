package lintcode2nd;

import java.util.ArrayList;
import java.util.List;

public class ZeroSumSubarray {

    // 暴力搜索，TLE
    public List<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int startIdx = 0; startIdx < len; startIdx ++) {

            if (nums[startIdx] == 0) {
                result.add(startIdx);
                result.add(startIdx);
                return result;
            }

            for (int endIdx = startIdx + 1; endIdx < len; endIdx++) {
                int sum = 0;
                for (int k = startIdx; k <= endIdx; k++) {
                    sum += nums[k];
                }
                if (sum == 0) {
                    result.add(startIdx);
                    result.add(endIdx);
                    return result;
                }
            }
        }

        throw new RuntimeException();

    }
}
