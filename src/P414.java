// Third Maximum Number
public class P414 {

    public int thirdMax(int[] nums) {
        // non-empty input ensured
        int n = nums.length;
        if (n == 1)  return nums[0];
        if (n == 2)  return Math.max(nums[0], nums[1]);
        
        int[] maxes = new int[3];   // top 3 max
        int count = 0;              // how many max values have been found
        boolean[] visited = new boolean[n];  // whether an element has been visited or not
        
        for (int i = 0; i < maxes.length; i++) {
            maxes[i] = Integer.MIN_VALUE;
            int mxIdx = -1;
            
            // find the next max (deduplicate first)
            for (int j = 0; j < n; j++) {
                if (i > 0 && nums[j] == maxes[i - 1]) {
                    visited[j] = true;
                    continue;
                }
                
                if (nums[j] >= maxes[i] && ! visited[j]) {
                    maxes[i] = nums[j];
                    mxIdx = j;
                }
            }
            
            if (mxIdx != -1) {
                visited[mxIdx] = true;
// System.out.printf("%dth max index: %d, value: %d\n",count + 1, mxIdx, maxes[count]);
                count++;
            }
        }
        
        if (count < 3)  return maxes[0];
        return maxes[2];
    }

}
