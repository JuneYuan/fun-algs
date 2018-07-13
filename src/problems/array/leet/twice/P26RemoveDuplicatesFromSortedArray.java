package problems.array.leet.twice;

public class P26RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
		
        int dedupLen = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[dedupLen]) {
                dedupLen++;
                nums[dedupLen] = nums[i];
            }
        }
        
        return dedupLen + 1;
    }

}
