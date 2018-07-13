public class P215KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }

        int ans = qSort(nums, 0, nums.length - 1, k);
        return ans;
    }

    private int qSort(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return nums[hi];
        }

        int m = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > nums[lo]) {
                m++;
                swap(nums, m, i);
            }
        }
        swap(nums, m, lo);

        if (m + 1 == k) {
            return nums[m];
        } else if (m + 1 > k) {
            return qSort(nums, lo, m - 1, k);
        } else {
            return qSort(nums, m + 1, hi, k);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
