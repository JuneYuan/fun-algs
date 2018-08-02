package problems.search.leet.twice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, list, result);

        return result;
    }

    private void dfs(int[] nums, int pos, List<Integer> list, List<List<Integer>> ret) {
        // add tmp result first
        ret.add(new ArrayList<Integer>(list));

        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }



    /**
     * csie.ntnu.edu.tw
     * 类比“索引存储”
     */
    private boolean[] solution = new boolean[5];

    public void enumerateCombinations1() {
        backtrack(0);
    }

    private void backtrack(int n) {
        // it's a solution
        if (n == 5) {
            for (int i = 0; i < 5; i++) {
                if (solution[i]) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;
        }

        // choose n, and enumerate the following
        solution[n] = true;
        backtrack(n + 1);

        // do not choose n, and enumerate the following
        solution[n] = false;
        backtrack(n + 1);
    }

    /**
     * 类比“循序存储”
     */
    private int[] subset = new int[5];

    public void enumerateCombinations2() {
        backtrack(0, 0);
    }

    private void backtrack(int n, int size) {
        // size stands for |subset|

        // it's a solution
        if (n == 5) {
            for (int i = 0; i < size; i++) {
                System.out.print(subset[i]);
            }
            System.out.println();
            return;
        }

        // choose n, and enumerate the following
        subset[size] = n;
        backtrack(n + 1, size + 1);

        // do not choose n, and enumerate the following
        backtrack(n + 1, size);
    }

}
