package problems.array.leet.once;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//two-sum
public class P1TwoSum {

	public int[] twoSum1(int[] nums, int target) {
		//two iterations:
		//first, build the map of <element, index>
		//second, check the component existence
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int component = target - nums[i];
			Integer idx = map.get(component);
			if (map.containsKey(component) && idx != i)
				return new int[] {i, idx};
		}
		
		throw new IllegalArgumentException("No solution");
	}

	public int[] twoSum2(int[] nums, int target) {
		//merge two iterations into one:
		//insert and look back within the same loop
		//注意：查询和插入的先后顺序，如果颠倒，样例［0,4,3,0］会出现"No solution"
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {			
			Integer component = target - nums[i];
			Integer idx = map.get(component);
			if (map.containsKey(component)) {
				return new int[] {idx, i};
			}

			map.put(nums[i], i);  
		}
		
		throw new IllegalArgumentException("No solution");
	}
	
	
	@Test
	public void test() {
		int[] nums = {3, 2, 4};
		int target = 6;
		System.out.println(Arrays.toString(twoSum2(nums, target)));
	}
}
