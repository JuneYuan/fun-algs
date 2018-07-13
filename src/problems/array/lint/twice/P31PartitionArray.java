package problems.array.lint.twice;

import java.util.*;

public class P31PartitionArray {

    public int solution1(int[] nums, int k) {
        int sz = nums.length;
        int i = 0, j = sz - 1;
        while (i <= j) {
            while (nums[i] < k && i <= j) {
                i++;
            }

            while (nums[j] >= k && i <= j) {
                j--;
            }

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }

        return i;
    }

    public int solution2(int[] nums, int k) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                int t = nums[i];
                nums[i] = nums[right];
                nums[right] = t;
                ++right;
            }
        }

        return right;
    }

}
