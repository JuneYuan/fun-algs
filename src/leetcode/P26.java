package leetcode;

public class P26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)    return nums.length;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

}
