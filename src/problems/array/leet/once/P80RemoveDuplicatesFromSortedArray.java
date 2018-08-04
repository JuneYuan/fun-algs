package problems.array.leet.once;

import java.util.Arrays;

public class P80RemoveDuplicatesFromSortedArray {

    public int solution(int[] nums) {
        if (nums == null) {
            throw new IllegalStateException();
        }
        if (nums.length <= 2) {
            return nums.length;
        }

        int newIndex = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[newIndex] || nums[i] != nums[newIndex - 1]) {
                newIndex++;
                nums[newIndex] = nums[i];
            }
        }

        return newIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 5, 5, 6, 6};
        new P80RemoveDuplicatesFromSortedArray().solution(nums);
        Arrays.toString(nums);
    }

}
