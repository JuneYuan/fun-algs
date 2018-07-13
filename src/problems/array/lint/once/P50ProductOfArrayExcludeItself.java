package lintcode1st.array;

import java.util.*;

public class P50ProductOfArrayExcludeItself {

    public List<Long> solution1(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            throw new IllegalStateException();
        }

        List<Long> result = new ArrayList<>();

        List<Long> leftMulti = new ArrayList<>(nums.size());
        List<Long> rightMulti = new ArrayList<>(nums.size());
        leftMulti.set(0, 1l);
        rightMulti.set(nums.size() - 1, 1l);
        for (int i = 1; i < nums.size(); i++) {
            leftMulti.set(i, leftMulti.get(i - 1) * nums.get(i));
            int j = nums.size() - 1 - i;
            rightMulti.set(j, rightMulti.get(j + 1) * nums.get(j));
        }

        for (int i = 0; i < nums.size(); i++) {
            result.set(i, leftMulti.get(i) * rightMulti.get(i));
        }

        return result;
    }

    public List<Long> solution2(List<Integer> nums) {
        List<Long> result = new ArrayList<>();

        // unionFind the left part first
        result.set(0, 1l);
        for (int i = 1; i < nums.size(); i++) {
            result.set(i, result.get(i - 1) * nums.get(i));
        }

        // unionFind the right part
        Long temp = 1l;
        for (int i = nums.size() - 1; i >= 0; i--) {
            result.set(i, result.get(i) * temp);
            temp *= nums.get(i);
        }

        return result;
    }

}
