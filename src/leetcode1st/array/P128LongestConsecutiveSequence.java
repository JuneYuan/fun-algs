package leetcode1st.array;

import java.util.HashSet;
import java.util.Set;

// 最大连续子数组
public class P128 {
    public int longestConsecutive(int[] A) {
        if (A == null || A.length == 0)  return 0;
        
        // add number to hashset
        Set<Integer> hashset = new HashSet<Integer>();
        for (int a : A) {
            hashset.add(a);
        }
        
        int lcs = 0;
        for (int a : A) {
            int i = a, cnt = 1;
            
            hashset.remove(a);
            // i--
            while (hashset.contains(--i)) {
                cnt++;
                hashset.remove(i);
            }
            // i++
            i = a;
            while (hashset.contains(++i)) {
                cnt++;
                hashset.remove(i);
            }
            // update lcs
            lcs = Math.max(lcs, cnt);
        }
        
        return lcs;
    }
}
