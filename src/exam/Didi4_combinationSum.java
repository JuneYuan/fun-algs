package exam;

import java.util.ArrayList;

/* 求数组中和为target的所有可能元素组合数，只输出得数，不需要输出具体是哪些元素
 * LeetCode P39, 40 Combination Sum
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Didi4_combinationSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int sum = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
        	nums[i] = in.nextInt();
        }
        
        List<List<Integer>> result = combinationSum(nums, sum);
        System.out.println(result.size());
        in.close();
    }

    private static List<List<Integer>> combinationSum(int[] nums, int sum) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<>();
    	if (nums == null)	return result;
    	
    	Arrays.sort(nums);
    	helper(nums, 0, sum, list, result);
    	
    	return result;
    }

    private static void helper(int[] nums, int pos, int gap, List<Integer> list, List<List<Integer>> result) {
    	if (gap == 0) {
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for (int i = pos; i < nums.length; i++) {
    		if (i != pos && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		
    		// 剪枝
    		if (gap < nums[i]) {
    			return ;
    		}
    		list.add(nums[i]);
    		helper(nums, i + 1, gap - nums[i], list, result);
    		helper(nums, i, gap - nums[i], list, result);
    		list.remove(list.size() - 1);
    	}
    }
}
