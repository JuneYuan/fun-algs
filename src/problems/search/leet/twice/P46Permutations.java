package problems.search.leet.twice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class P46Permutations {

    /**
     * Recursion (using subsets template)
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        dfs(nums, list, result);

        return result;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list, result);

            list.remove(list.size() - 1);
        }
    }


    /**
     * Recursion
     */
    public List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();

        if (nums == null) {
            return result;
        } else {
            // convert int[] to List<Integer>
            for (int item : nums) {
                list.add(item);
            }
        }

        if (nums.length <= 1) {
            result.add(list);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] numsNew = new int[nums.length - 1];
            System.arraycopy(nums, 0, numsNew, 0, i);
            System.arraycopy(nums, i + 1, numsNew, i, nums.length - i - 1);

            List<List<Integer>> resTemp = solution2(numsNew);
            for (List<Integer> temp : resTemp) {
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }


    /**
     * Iteration
     */
    public List<List<Integer>> solution3(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // deep copy (do not change nums)
        int[] perm = Arrays.copyOf(nums, nums.length);
        // sort first!!!
        Arrays.sort(perm);

        while (true) {
            // step0: add perm into result
            List<Integer> tmpList = new ArrayList<Integer>();
            for (int i : perm) {
                tmpList.add(i);
            }
            result.add(tmpList);

            // step1: search the first perm[k] < perm[k+1] backward
            int k = -1;
            for (int i = perm.length - 2; i >= 0; i--) {
                if (perm[i] < perm[i - 1]) {
                    k = i;
                    break;
                }
            }
            // if current rank is the largest, exit while loop
            if (k == -1) {
                break;
            }

            // step2: search the first perm[k] < perm[l] backward
            int l = perm.length - 1;
            while (l > k && perm[l] <= perm[k]) {
                l--;
            }

            // step3: swap perm[k] with perm[l]
            int tmp = perm[k];
            perm[k] = perm[l];
            perm[l] = tmp;

            // step4: reverse between k+1 and perm.length-1;
            reverse(perm, k + 1, perm.length - 1);
        }

        return result;
    }

    private void reverse(int[] nums, int lb, int ub) {
        for (int i = lb, j = ub; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
