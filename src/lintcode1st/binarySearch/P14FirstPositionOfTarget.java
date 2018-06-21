package lintcode1st.binarySearch;

public class P14FirstPositionOfTarget {

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }

        /*
        1) why start and end from beyond?
        2) why loop condition 'start + 1 < end'?
        */
        int start = -1, end = nums.length;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end == nums.length || nums[end] != target) {
            return -1;
        } else {
            return end;
        }
    }

}
