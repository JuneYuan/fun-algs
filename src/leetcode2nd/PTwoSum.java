package leetcode2nd;

import java.util.HashMap;
import java.util.Map;

public class PTwoSum {
	public int[] twoSum(int[] nums, int target) {
		return solution1(nums, target);
	}
	
	private int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>(); // key: element, value: index
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            Integer difIndex = visited.get(dif);
            if (difIndex != null) {
                return new int[]{difIndex, i};
            }
            
            visited.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }

	private int[] solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("No two sum solution");
        }
        
        Map<Integer, Integer> visited = new HashMap<>(); // key: element, value: index
        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (visited.containsKey(dif)) {
                index1 = visited.get(dif);
                index2 = i;
                return new int[]{index1, index2};
            }
        }
        
        throw new IllegalArgumentException("No two sum solution");    
    }
}
