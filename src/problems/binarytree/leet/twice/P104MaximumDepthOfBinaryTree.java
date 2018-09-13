package problems.binarytree.leet.twice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P104MaximumDepthOfBinaryTree {

    /**
     * recursion
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(solution1(root.left), solution1(root.right)) + 1;
    }

    /**
     * iteration with stack
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode curr = null, prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                stack.pop();
            }

            prev = curr;

            if (stack.size() > maxDepth) {
                maxDepth = stack.size();
            }
        }

        return maxDepth;
    }

    /**
     * iteration with queue
     */
    public int solution3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            depth++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return depth;
    }

}
