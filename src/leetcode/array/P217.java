package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class P217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer k : nums) {
            if (!set.add(k)) {
                return true;
            }
        }
        
        return false;
    }
}
