package problems.array.leet.once;

import java.util.Arrays;

public class P26RemoveDuplicatesFromSortedArray {

    public int solution(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        int newIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newIndex]) {
                newIndex++;
                nums[newIndex] = nums[i];
            }
        }

        return newIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 5, 5, 6, 6};
        new P26RemoveDuplicatesFromSortedArray().solution(nums);
        Arrays.toString(nums);
    }

}
