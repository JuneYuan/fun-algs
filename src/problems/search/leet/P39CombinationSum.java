package leetcode1st.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        if (candidates == null)     return result;
        
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, result);
        
        return result;
    }

    private void helper(int[] nums, int pos, int gap, List<Integer> list, List<List<Integer>> result) {
        if (gap == 0) {
            // add new object for result
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            // cut invalid num
            if (gap < nums[i]) {
                return;
            }
            list.add(nums[i]);
            helper(nums, i, gap - nums[i], list, result);  // 元素可以重复取，故递归时传入的索引值不自增
            list.remove(list.size() - 1);
        }
    }
    
}
