package leetcode1st.array;

import java.util.*;

public class P41FirstMissingPositive {

    public int solution1(int[] nums) {
        int sz = nums.length;
        for (int i = 0; i < sz; i++) {
            while (nums[i] > 0 && nums[i] <= sz
                  && nums[i] != i + 1
                  && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < sz; i++) {
            if (nums[i] != i + 1) {
                return (i + 1);
            }
        }

        return (sz + 1);
    }

}
