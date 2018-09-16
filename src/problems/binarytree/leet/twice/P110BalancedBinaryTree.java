package problems.binarytree.leet.twice;

import java.util.*;

public class P104BalancedBinaryTree {
    Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();

    {
        nodeDepthMap.put(null, 0);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        processDepthMap(root);

        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lDepth = nodeDepthMap.get(root.left), rDepth = nodeDepthMap.get(root.right);
        if (lDepth <= 1 && rDepth <= 1) {
            return true;
        }

        if (Math.abs(lDepth - rDepth) > 1) {
            return false;
        }

        return helper(root.left) && helper(root.right);
    }

    private int processDepthMap(TreeNode root) {
        if (root == null) {
            nodeDepthMap.put(null, 0);
            return 0;
        }

        if (root != null && root.left == null && root.right == null) {
            nodeDepthMap.put(root, 1);
            return 1;
        }

        int lDepth = processDepthMap(root.left), rDepth = processDepthMap(root.right);
        int currDepth = Math.max(lDepth, rDepth) + 1;
        nodeDepthMap.put(root, currDepth);
        return currDepth;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b0 = new TreeNode(20);
        TreeNode b1 = new TreeNode(21);
        TreeNode c0 = new TreeNode(30);
        TreeNode c1 = new TreeNode(31);
        TreeNode d0 = new TreeNode(40);
        TreeNode d1 = new TreeNode(41);

        a.left = b0;  a.right = b1;
        b0.left = c0;  b0.right = c1;
        c0.left = d0;  c0.right = d1;

        System.out.println(new P104BalancedBinaryTree().isBalanced(a));
    }

}

class Solution2 {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)   return 0;

        int lDepth = maxDepth(root.left), rDepth = maxDepth(root.right);
        if (lDepth == -1 || rDepth == -1 || Math.abs(lDepth - rDepth) > 1) {
            return -1;
        }

        return 1 + Math.max(lDepth, rDepth);
    }
}
