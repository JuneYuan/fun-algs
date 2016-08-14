package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P138 {
	// 方法一：两重循环
    public ArrayList<Integer> subarraySum_n2(int[] nums) {
    }

    // 方法二：比较子串和(TLE)
    public ArrayList<Integer> subarraySum_n2_(int[] nums){
    	
    }
    
    // 方法三：哈希表
    public ArrayList<Integer> subarraySum_n(int[] nums) {
    	ArrayList<Integer> result = new ArrayList<>();
    	Map<Integer, Integer> sums = new HashMap<>();   // <sum from 0 to pos, pos>
    	
    	int curSum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		curSum += nums[i];
    		
    		if (curSum == 0) {
    			result.add(0);
    			result.add(i);
    			return result;
    		}
    		
    		Integer lastOccuredPos = sums.get(curSum);
    		if (lastOccuredPos != null) {
    			result.add(lastOccuredPos + 1);
    			result.add(i);
    			return result;
    		}
    		
    		sums.put(curSum, i);
    	}
    	return result;
    }
}
