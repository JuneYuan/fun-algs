package lintcode1st.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P139 {
    
	public Integer[] subarraySumClosest(int[] nums) {
		Collection<Integer> result = new TreeSet<>();
		if (nums == null || nums.length == 0)	return result.toArray(new Integer[0]);
		final int N = nums.length;
		
		// 计算子序列和，数据结构？Map<Sum, Index>
		int[] sum = new int[N];
		Map<Integer, Integer> mapHelper = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int curr1 = 0; 
		int curr2 = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				sum[i] = nums[i];
			} else {
				sum[i] = nums[i] + sum[i - 1];
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (mapHelper.containsKey(sum[i])) {
				result.add(mapHelper.get(sum[i] + 1));
				result.add(i);
				return result.toArray(new Integer[0]);
			} else {
				mapHelper.put(sum[i], i);
			}
		}
		
		// 按子序列和排序
		// 计算排序后相邻元素的|delta|，取最小者
		Arrays.sort(sum);
		for (int i = 0; i < N - 1; i++) {
			int tmp = Math.abs(sum[i] - sum[i+1]);
			if (tmp < min) {
				min = tmp;
				curr1 = sum[i];
				curr2 = sum[i+1];
			}
		}
		result.add(curr1);
		result.add(curr2);
		
		return result.toArray(new Integer[0]);
	}
}
