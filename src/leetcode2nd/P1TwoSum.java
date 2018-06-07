package leetcode2nd;

import java.util.*;

public class P1TwoSum {

    public int[] solution1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> visited = new HashMap<>();

        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int shortage = target - curr;
            if (visited.containsKey(shortage)) {
                index1 = visited.get(shortage);
                index2 = i;
                return new int[]{index1, index2};
            }

            visited.put(curr, i);
        }

        return null;
    }

    public int[] solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = null;

        List<Pair> numIndex = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Pair pair = new Pair(nums[i], i);
            numIndex.add(pair);
        }
        Collections.sort(numIndex, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.first - p2.first;
            }
        });

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int operand1 = numIndex.get(start).first;
            int operand2 = numIndex.get(end).first;

            if (operand1 + operand2 > target) {
                end--;
            } else if (operand1 + operand2 < target) {
                start++;
            } else {
                int index1 = numIndex.get(start).second;
                int index2 = numIndex.get(end).second;
                result = new int[]{Math.min(index1, index2), Math.max(index1, index2)};
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,15,11};
        int target = 9;
        System.out.println(Arrays.toString(new P1TwoSum().solution2(nums, target)));
    }

}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

}
