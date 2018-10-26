package problems.search.leet.twice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class P46Permutations {

    public List<List<Integer>> permute(int[] A) {
        List<List<Integer>> ret = new ArrayList<>();
        if (A == null || A.length == 0)     return ret;

        List<Integer> list = new ArrayList<>();
        dfs(A, list, ret);

        return ret;
    }

    private void dfs(int[] A, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() == A.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (list.contains(A[i]))    continue;
            list.add(A[i]);
            dfs(A, list, ret);
            list.remove(list.size() - 1);
        }
    }

}

class Sln2 {

    public List<List<Integer>> permute(int[] A) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (A == null) {
            return ret;
        } else {
            for (int item : A) {
                list.add(item);
            }
        }

        if (A.length <= 1) {
            ret.add(list);
            return ret;
        }

        for (int i = 0; i < A.length; i++) {
            int[] B = new int[A.length - 1];
            System.arraycopy(A, 0, B, 0, i);
            System.arraycopy(A, i + 1, B, i, A.length - i - 1);

            List<List<Integer>> tmpRet = permute(B);
            for (List<Integer> tmp : tmpRet) {
                tmp.add(A[i]);
                ret.add(tmp);
            }
        }

        return ret;
    }

}