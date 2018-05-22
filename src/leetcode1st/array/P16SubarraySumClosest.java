package leetcode1st.array;

import java.util.*;

public class P16SubarraySumClosest {

    public int[] solution1(int[] nums) {
        Map<Integer, Integer> sumHash = new TreeMap<>();
        int currSum = 0, closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            sumHash.put(currSum, i);
            closestSum = currSum < closestSum ? currSum : closestSum;
            // Assert: sumHash has an ordered key set
        }

        int index = 0, closestSum2 = Integer.MAX_VALUE;
        for (int i = 1; i < sumHash.size(); i++) {

        }

        // TODO
        return null;
    }

    /*public int[] solution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }

        List<Integer> result = new ArrayList<>();
        List<Pair> sumIndex = new ArrayList<>(nums.length + 1);

        sumIndex.set(0, new Pair(0, 0));
        for (int i = 0; i < nums.length; i++) {
            int first = sumIndex.get(i).first + nums[i];
            int second = i + 1;
            sumIndex.add(i + 1, new Pair(first, second));
        }

        Collections.sort(sumIndex);

        int minDiff = Integer.MAX_VALUE, closestIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            int sumDiff = Math.abs(sumIndex.get(i).getFirst() - sumIndex.get(i).getFirst());
            if (minDiff > sumDiff) {
              minDiff = sumDiff;
              closestIndex = i;
            }
        }

        int leftIndex = Math.min(sumIndex.get(closestIndex - 1).getSecond(),
                                sumIndex.get(closestIndex).getSecond());
        int rightIndex = -1 + Math.max(sumIndex.get(closestIndex - 1).getSecond(),
                                      sumIndex.get(closestIndex).getSecond());
        return new int[]{leftIndex, rightIndex};
    }*/

    public int solution2Beta(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }

        List<Pair> sumIndex = new ArrayList<>(nums.length + 1);

        sumIndex.add(new Pair(0, 0));
        for (int i = 0; i < nums.length; i++) {
            int first = sumIndex.get(i).first + nums[i];
            int second = i + 1;
            sumIndex.add(new Pair(first, second));
        }

        Collections.sort(sumIndex);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            Pair currPair = sumIndex.get(i);
            Pair prevPair = sumIndex.get(i - 1);
            int sumDiff;
            if (currPair.getSecond() > prevPair.getSecond()) {
                sumDiff = currPair.getFirst() - prevPair.getFirst();
            } else {
                sumDiff = prevPair.getFirst() - currPair.getFirst();
            }

            int targetDiff = Math.abs(sumDiff - target);
            minDiff = Math.min(minDiff, targetDiff);
        }

        return minDiff;
    }

}

class Pair implements Comparable<Pair> {
    int first, second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Pair that) {
        return (this.first - that.first);
    }
}
