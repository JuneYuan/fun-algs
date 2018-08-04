package problems.array.leet.once;

import java.util.*;

import org.junit.Test;

// 3Sum
public class P15ThreeSum {

    /**
     * 排序 + 哈希表 + 2Sum
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (nums[i] + tmp > 0) {
                    right--;
                } else if (nums[i] + tmp < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * TODO DP待验证和调试
     */
    public List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        @SuppressWarnings("unchecked")
		Map<Integer, ArrayList<Integer>>[][] dp = (Map<Integer, ArrayList<Integer>>[][]) new Object[A.length][4];
        // Map<Integer, ArrayList<Integer>>[][] dp = new HashMap<Integer, ArrayList<Integer>>[A.length][4];
        // init
        for (int i = 0; i < A.length; i++) {
            Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
            map.put(0, new ArrayList<>());
            dp[i][0] = map;
        }
        // handle DP
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j <= 3; j++) {
                // init with { f(i - 1, j) }
                Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(dp[i - 1][j]);
                // append { f(i - 1, j - 1) + Ai } 
                if (i >= 1) {
                    for (Map.Entry<Integer, ArrayList<Integer>> entry : dp[i - 1][j - 1].entrySet()) {
                        int sum = entry.getKey() + A[i];
                        ArrayList<Integer> list = new ArrayList<>(entry.getValue());
                        list.add(A[i]);
                        map.put(sum, list);
                    }
                }
                
                dp[i][j] = map; 
            }
        }
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : dp[A.length - 1][3].entrySet()) {
            if (entry.getKey() == 0) {
                result.add(entry.getValue());
            }
        }
        
        return result;
    }

    @Test
    public void test() {
    	int[] A = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
    	// int[] A = new int[]{-1,0,1,2,-1,-4};
    	for (List<Integer> list : threeSum(A)) {
    		System.out.println(list);
    	}
    }
}
