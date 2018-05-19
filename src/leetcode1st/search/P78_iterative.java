package leetcode1st.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

// 迭代写法
public class P78_iterative {

	public List<List<Integer>> subsets_iterative(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)	return result;
		
		Arrays.sort(nums);
		// 每个子集都对应[0, 2^len]中的唯一“编码”
		int cnt = (int) Math.pow(2, nums.length);
		for (int i = 0; i < cnt; i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if ((i & (1 << j)) != 0) {
					temp.add(nums[j]);
				}
			}
			
			result.add(temp);
		}
		
		return result;
	}
		
	@Test
	public void test() {
		int[] nums = new int[]{1, 2, 3};
		for(List<Integer> list : subsets_iterative(nums)) {
			System.out.println(list);
		}
	}
	
}
