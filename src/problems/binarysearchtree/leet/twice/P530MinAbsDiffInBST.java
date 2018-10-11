package problems.binarysearchtree.leet.twice;

public class P530MinAbsDiffInBST {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)   return min;

        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }

        prev = root;
        getMinimumDifference(root.right);
        return min;
    }
}
