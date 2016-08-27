package leetcode;

public class P53 {

	// 方法一：Kadane's algorithm / 贪心
    public int maxSubArray_greedy(int[] nums) {
        if (nums == null || nums.length == 0)	return 0;
        
        int sum = 0, result = Integer.MIN_VALUE;
        for (int num : nums) {
        	sum += num;
        	// update maxSub
        	result = Math.max(result, sum);
        	// drop negtive sum
        	sum = Math.max(sum, 0);
        }
        
        return result;
    }

    public int maxSubArray_greedy_withPosition(int[] nums) {
    	int sum = 0, result = Integer.MIN_VALUE;
    	int l = 0, r = 0, maxL = 0, maxR = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if (sum > result) {
    			result = sum;
    			r = i;
    			maxL = l;
    			maxR = r;
    		}
    		
    		if (sum < 0) {
    			sum = 0;
    			l = i + 1;
    			r = l;
    		}
    	}
    	
    	return result;
    }
    
    // 方法二：动态规划1（区间和）
    public int maxSubArray_dpInterval(int[] nums) {
    	if (nums == null || nums.length == 0)	return 0;
    	
    	int sum = 0, minSum = 0, maxSubSum = Integer.MIN_VALUE;
    	for (int num : nums) {
    		minSum = Math.min(minSum, sum);
    		sum += num;
    		maxSubSum = Math.max(maxSubSum, sum - minSum);
    	}
    	
    	return maxSubSum;
    }

    // 方法三：动态规划2（局部与全局）
    public int maxSumArray_dpLocalGlobal(int[] nums){
    	if (nums == null || nums.length == 0)	return 0;
    	
    	int len = nums.length;
    	int[] local = new int[len];
    	int[] global = new int[len];
    	local[0] = nums[0];
    	global[0] = nums[0];
    	for (int i = 1; i < len; i++) {
    		// drop local[i-1] < 0
    		local[i] = Math.max(nums[i], local[i - 1] + nums[i]);
    		// update global with local
    		global[i] = Math.max(global[i - 1], local[i]);
    	}
    	
    	return global[len - 1];
    }
}
