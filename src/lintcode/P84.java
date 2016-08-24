package lintcode;

import java.util.ArrayList;
import java.util.List;

public class P84 {

    public List<Integer> singleNumberIII(int[] A) {
    	List<Integer> result = new ArrayList<>();
    	// if (A == null || A.length == 0)	return nums;
    	
    	int x1XORx2 = 0;
    	for (int num : A) {
    		x1XORx2 ^= num;
    	}
    	
    	// get the last 1 bit of x1XORx2, e.g. 1010 ==> 0010
    	int last1Bit = x1XORx2 - (x1XORx2 & (x1XORx2 - 1));
    	int single1 = 0, single2 = 0;
    	for (int num : A) {
    		if ((last1Bit & num) == 0) {
    			single1 ^= num;
    		} else {
    			single2 ^= num;
    		}
    	}
    	
    	result.add(single1);
    	result.add(single2);    		
        return result;
        
    }

}
