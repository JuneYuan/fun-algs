package leetcode1st.array;

import java.util.Arrays;

public class P16ThreeSumClosest {

    /**
     * 排序 + 两根指针 + 2sum + 优化过滤
     */
    public int solution(int[] nums, int target) {
        if (nums.length < 3) {
            throw new IllegalStateException();
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        int n = nums.length, temp;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - result) > Math.abs(target - temp)) {
                    result = temp;
                }
                if (result == target) {
                    return result;
                }

                if (temp > target) {
                    k--;
                } else {
                    j++;
                }
//                (temp > target) ? k-- : j++;
            }
        }
        return result;
    }
}
