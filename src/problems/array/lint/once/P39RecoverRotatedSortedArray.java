package lintcode1st.array;

import java.util.*;

public class P39RecoverRotatedSortedArray {

    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() < 1) {
            throw new IllegalStateException();
        }

        int pos = 1;
        while (pos < nums.size()) {
            if (nums.get(pos - 1) > nums.get(pos)) {
                break;
            }
            pos++;
        }

        invert(nums, 0, pos - 1);
        invert(nums, pos, nums.size() - 1);
        invert(nums, 0, nums.size() - 1);
    }

    private void invert(ArrayList<Integer> nums, int left, int right) {
        while (left < right) {
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            left++;
            right--;
        }
    }

}
