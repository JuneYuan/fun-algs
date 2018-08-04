package problems.array.lint.once;

public class P373PartitionByOddAndEven {

    public void partitionArray(int[] nums) {
        if (nums == null) {
            throw new IllegalStateException();
        }

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            while (lo < hi && isOdd(nums[lo])) {
                lo++;
            }

            while (lo < hi && isEven(nums[hi])) {
                hi--;
            }

            if (lo < hi) {
                swap(nums, lo, hi);
            }

        }
    }

    private boolean isOdd(int k) {
        return (k % 2) == 1;
    }
    private boolean isEven(int k) {
        return !isOdd(k);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
