package problems.binarytree.lint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P245Subtree {
    /**
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null)     return true;

        if (T1 == null)     return false;

        List<TreeNode> allNodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(T1);
        while (!q.isEmpty()) {
            int qSz = q.size();
            for (int i = 0; i < qSz; i++) {
                TreeNode node = q.poll();
                allNodes.add(node);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        // iterate those nodes and check equality
        for (TreeNode candidate : allNodes) {
            if (isEqualTree(candidate, T2)) {
                return true;
            }
        }

        return false;
    }

    private boolean isEqualTree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }

        if ((T1 == null && T2 != null) || (T1 != null && T2 == null)) {
            return false;
        }

        if (T1.val != T2.val) {
            return false;
        }

        if ((T1.left == null && T2.left != null) || (T1.left != null && T2.left == null)) {
            return false;
        }

        if ((T1.right == null && T2.right != null) || (T1.right != null && T2.right == null)) {
            return false;
        }

        return isEqualTree(T1.left, T2.left) && isEqualTree(T1.right, T2.right);
    }
}

class DoubleRecurseSln {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null)     return true;

        if (T1 == null)     return false;

        return isEqualTree(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    private boolean isEqualTree(TreeNode T1, TreeNode T2) {
        // 与P245Subtree相同
        return false;
    }

    private boolean isSameNullability(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)     return true;
        if (node1 == null || node2 == null)     return false;
        return true;
    }
}