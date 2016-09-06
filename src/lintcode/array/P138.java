package lintcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P138 {
	// 方法一：两重循环
    public ArrayList<Integer> subarraySum_n2(int[] nums) {
    	ArrayList<Integer> result = new ArrayList<>();
    	int currSum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		for (int j = i; j < nums.length; j++) {
    			currSum += nums[j];
    			if (currSum == 0) {
    				result.add(i);
    				result.add(j);
    				break;
    			}
    		}
    		if (!result.isEmpty())	break;
    		currSum = 0;
    	}
    	
    	return result;
    }

    // 方法二：比较子串和(TLE)
    public ArrayList<Integer> subarraySum_n2_(int[] nums){
    	ArrayList<Integer> result = new ArrayList<>();
    	ArrayList<Integer> sums = new ArrayList<>(); 
    	int currSum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		currSum += nums[i];
    		
    		if (currSum == 0) {
    			result.add(0);
    			result.add(i);
    			return result;
    		}
    		
    		int bgnIdx = sums.indexOf(currSum);
    		if (bgnIdx != -1) {
    			result.add(bgnIdx + 1);
    			result.add(i);
    			return result;
    		}
    		
    		sums.add(currSum);
    	}
    	return result;
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
    
    @Test
    public void test() {
    	int[] nums = {-3, 1, 2, -3, 4};
    	System.out.println(subarraySum_n2(nums));
    }
}
