package leetcode;

public class P41 {

    public int firstMissingPositive(int[] nums) {
    	int len = nums.length;
    	for (int i = 0; i < len; i++) {
    		/*
    		 * condition: 
    		 * 1. nums[i] is POSITIVE
    		 * 2. nums[i] is in the RANGE
    		 * 3. target is different
    		 * (4. nums[i] NOT in RIGHT SLOT, to avoid swapping with itself)
    		 */
    		while (nums[i] > 0 
    				&& nums[i] <= len
    				&& nums[i] != nums[nums[i] - 1]
    	    		&& nums[i] != i + 1) {
    			int tmp = nums[nums[i] - 1];
    			nums[nums[i] - 1] = nums[i];
    			nums[i] = tmp;
    		}
    	}
    	
    	for (int i = 0; i < len; i++) {
    		if (nums[i] != i + 1) {
    			return i + 1;
    		}
    	}
    	return len + 1;
    }

}
