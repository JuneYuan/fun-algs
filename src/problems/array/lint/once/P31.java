package lintcode1st.array;

public class P31 {
    public int partitionArray(int[] nums, int k) {
    	int right = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] < k && i > right) {
    			int tmp = nums[i];
    			nums[i] = nums[right];
    			nums[right] = tmp;
    			++right;
    		}
    	}
    	return right;
    }

    public int partitionArray1(int[] nums, int k) {
    	int left = 0, right = nums.length - 1;
    	while (left <= right) {
    		// 从左向右，直到找到 >=k 的索引为止
    		while (left <= right && nums[left] < k) 
    			++left;
    		// 从右向左，直到找到 <k 的索引为止
    		while (left <= right && nums[right] >= k)
    			--right;
    		// 注意进行越界检查！
    		if (left <= right) {
    			int tmp = nums[left];
    			nums[left] = nums[right];
    			nums[right] = tmp;
    			++left;
    			--right;
    		}
    	}
    	return left;
    }
}
