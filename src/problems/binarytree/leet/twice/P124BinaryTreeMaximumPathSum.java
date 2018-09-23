package problems.binarytree.leet.twice;

public class P124BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        return helper(root).maxPath;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            // maxPath should be MIN_VALUE to avoid negtive
            return new Result(0, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(0, singlePath);   // drop negative

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, root.val + left.singlePath + right.singlePath);

        return new Result(singlePath, maxPath);
    }
}

class Result {
    int singlePath, maxPath;

    Result(int singlePath, int maxPath) {
        this.singlePath = singlePath;
        this.maxPath = maxPath;
    }
}
