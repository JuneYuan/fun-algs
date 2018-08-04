package problems.array.leet.once;

import java.util.*;

public class P560SubArraySumK {

    /**
     * solution1与solution2思路相同，都是基于sum(j) - sum(i) = k和哈希表求解。
     * 不同在于，solution1更直观：hash<K,V>中的V直接记录所有满足sum(i)=K的下标i；
     * 而solution2一步到位，hash<K,V>中的V用来记录满足sum(i)=K的下标个数。
     */

    public int solution1(int[] nums, int k) {
        int ans = 0;

        Map<Integer, ArrayList<Integer>> hash = new HashMap<>();
        hash.put(0, new ArrayList<>(Arrays.asList(new Integer[] {-1})));
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (hash.containsKey(currSum - k)) {
                ArrayList<Integer> indexes = hash.get(currSum - k);
                ans += indexes.size();
            }

            if (hash.containsKey(currSum)) {
                ArrayList<Integer> indexes = hash.get(currSum);
                indexes.add(i);
                hash.put(currSum, indexes);
            } else {
                hash.put(currSum, new ArrayList<>(Arrays.asList(new Integer[] {i})));
            }
        }

        return ans;
    }

    public int solution2(int[] nums, int k) {
        int ans = 0;

        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (hash.containsKey(currSum - k)) {
                ans += hash.get(currSum - k);
            }

            if (hash.containsKey(currSum)) {
                hash.put(currSum, hash.get(currSum) + 1);
            } else {
                hash.put(currSum, 1);
            }
        }

        return ans;
    }

}
