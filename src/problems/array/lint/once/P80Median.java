public class P80Median {

    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }

        int n = nums.length;
        return kth(nums, 0, n - 1, (n + 1)/2);
    }

    private int kth(int[] nums, int left, int right, int k) {
        int m = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                m++;
                swap(nums, i, m);
            }
        }

        swap(nums, left, m);

        if (k == m - left + 1) {
            return nums[m];
        } else if (k > m - left + 1) {
            return kth(nums, m + 1, right, k - (m - left + 1));
        } else {
            return kth(nums, left, m - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
