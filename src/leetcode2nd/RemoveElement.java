package leetcode2nd;

public class RemoveElement {

	/**
	 * 遍历nums,遇到不等于val的值则assign
	 * 两个指针，从左向右，一个进行遍历，一个指向接收assign的元素
     */
	public int method1(int[] nums, int val) {
		int left = 0;

		for (int num : nums) {
			if (num != val) {
				nums[left++] = num;
			}
		}
		
		return left;
	}

	/**
	 * 扫描nums，遇到等于val的值则与其他值交换
	 * 两个指针，一个向右进行扫描，一个向左指向交换值
     */
	public int method2(int[] nums, int val) {
		int right = nums.length;
		for (int i = 0; i < right; i++) {
			if (nums[i] == val) {
				nums[i] = nums[right - 1];
				right--;
				i--;
			}
		}

		return right;
	}
}
