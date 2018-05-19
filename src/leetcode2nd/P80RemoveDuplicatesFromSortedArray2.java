package leetcode2nd;

public class P80RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
		return sln1(nums);
	}
	
	private int sln1(int[] nums) {
        if (nums == null)   return -1;
        if (nums.length <= 2)   return nums.length;
        
        int dedupIndex = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[dedupIndex]
               || nums[i] != nums[dedupIndex]) {
                dedupIndex++;
                nums[dedupIndex] = nums[i];
            }
        }
        
        return dedupIndex + 1;		
	}
}
