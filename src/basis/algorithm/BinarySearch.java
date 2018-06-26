package basis.algorithm;

public class BinarySearch {

    /**
     * lower bound
     * 求给定升序数组中大于等于目标值的最小索引
     */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb)/2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1;
    }

    /**
     * upper bound
     * 求给定升序数组中小于等于目标值的最大索引
     */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb)/2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }

    /**
     *  最优解
     */
    public static double solve(double[] nums, int K) {
        double lb = 0.00, ub = 10e5 + 0.01;

        for (int i = 0; i < 100; i++) {
            double mid = lb + (ub - lb)/2;
            if (judge(nums, mid, K)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb;
    }

    // 判断给定数组num[]能否切割出K条长度均为seg的绳子
    private static boolean judge(double[] nums, double seg, int k) {
        int count = 0;
        for (double val : nums) {
            count += Math.floor(val / seg);
        }
        return count >= k;
    }

    /**
     * 模版三。易读。
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

}
