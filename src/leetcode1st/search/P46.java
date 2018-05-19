package leetcode1st.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class P46 {
	// 方法一：Recursion (using subsets template)
	public List<List<Integer>> permute_RecursionSubset(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)	return result;
		
		List<Integer> list = new ArrayList<>();
		dfs(nums, list, result);
		
		return result;
	}
	private void dfs(int[] nums, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))		continue;
			list.add(nums[i]);
			dfs(nums, list, result);
			// 恢复状态，不影响下次搜索结果
			list.remove(list.size() - 1);
		}
	}

	// 方法二：从全排列的数学定义出发
	public List<List<Integer>> permute_Recursion(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();	// 注意类型转换
		List<Integer> numsAsList = new ArrayList<>();
		
		if (nums == null || nums.length == 0) {
			return result;
		} else {
			// convert: int[] -> List<Integer>
			for (int num : nums)
				numsAsList.add(num);
		}
		
		if (nums.length == 1) {
			result.add(numsAsList);
			return result;
		}
				
		for (int i = 0; i < nums.length; i++) {
			// 把nums[]数组去掉第 i 个元素后的新数组，赋给numsNew
			int[] numsNew = new int[nums.length - 1];
			System.arraycopy(nums, 0, numsNew, 0, i);
			System.arraycopy(nums, i + 1, numsNew, i, nums.length - 1 - i);
			
			// 递归求得子数组numsNew[]的全排列，再把 i 追加在后边
			List<List<Integer>> resTemp = permute_Recursion(numsNew);
			for (List<Integer> temp : resTemp) {
				temp.add(nums[i]);
				result.add(temp);
			}
		}
		
		return result;
	}

	// 方法三：Ieration (with Array)
	public List<List<Integer>> permute_ArrayIteration(int[] arr) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		if (arr == null || arr.length == 0)	return ret;
		
		// deep copy
		List<Integer> perm = new ArrayList<>();
		for (int a : arr) {
			perm.add(a);
		}
		Collections.sort(perm);  // sort first!

		// keep adding permutation to ret, in dict order
		do {
			ret.add(new ArrayList<>(perm));
		} while (hasNextPermutation(perm));

		return ret;
	}
	private boolean hasNextPermutation(List<Integer> perm) {
		
		// Find longest non-increasing suffix (weakly decreasing)
		int i = perm.size() - 1;
		while (i > 0 && perm.get(i - 1) >= perm.get(i)) {
			i--;
		}
		// Now i is the head index of the suffix
		
		// Are we at the last permutation already?
		if (i <= 0) {
			return false;
		}
		
		// let nums[i - 1] be the pivot
		// Find rightmost element that exceeds the pivot
		int pivot = perm.get(i - 1);
		int j = perm.size() - 1;
		while (perm.get(j) <= pivot) {
			j--;
		}
		// Now nums[j] will become the new pivot
		
		// Swap the pivot with nums[j]
		perm.set(i - 1, perm.get(j));
		perm.set(j, pivot);
		
		// Reverse the suffix
		for (j = perm.size() - 1; i < j; i++, j--) {
			int temp = perm.get(i);
			perm.set(i, perm.get(j));
			perm.set(j, temp);
		}
		
		return true;		
	}
		
	
	@Test
	public void test() {
		// int[] nums = new int[0];
		int[] nums = new int[]{3};
		// int[] nums = new int[]{1, 2, 3};
		for (List<Integer> sequence : permute_Recursion(nums)) {
			System.out.println(sequence);
		}
	}
	
	@Test
	public void testZeroSizeArray() {
		// 声明和使用size为0的数组，不会报错
		int[] A = new int[0];
		for (int a : A) {
			System.out.println(a);
		}
	}

	@Test
	public void testListOfZeroSizeLists() {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		ret.add(a);
		ret.add(b);
		ret.add(c);
		System.out.println(ret);
	}

	@Test
	public void testIter() {
		// int[] nums = new int[0];
		// int[] nums = new int[]{3};
		int[]  nums = new int[]{1, 2, 3};
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : nums)	list.add(num);
		
		for (List<Integer> sequence : permute_ArrayIteration(nums)) {
		// for (List<Integer> sequence : permute_ListIteration(list)) {
			System.out.println(sequence);
		}
	}

}
