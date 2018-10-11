package problems.binarysearchtree.lint.twice;

import java.util.ArrayList;
import java.util.List;

public class P11SearchRangeInBST {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> ret = new ArrayList<>();
        helper(root, k1, k2, ret);
        return ret;
    }

    private void helper(TreeNode root, int k1, int k2, List<Integer> ret) {
        if (root == null)   return;

        if (root.left != null && root.val >= k1) {
            helper(root.left, k1, k2, ret);
        }

        if (k1 <= root.val && root.val <= k2) {
            ret.add(root.val);
        }

        if (root.right != null && root.val <= k2) {
            helper(root.right, k1, k2, ret);
        }
    }

}
