package problems.binarytree.leet.twice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P144BinaryTreePreorderTraversal {

    /**
     * solution1: divide and conquer
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            // divide
            List<Integer> left = solution1(root.left);
            List<Integer> right = solution1(root.right);
            // merge
            result.add(root.val);
            result.addAll(left);
            result.addAll(right);
        }

        return result;
    }

    /**
     * solution2: traversal
     */
    private List<Integer> result = new ArrayList<>();
    public List<Integer> solution2(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            solution2(root.left);
            solution2(root.right);
        }

        return result;
    }

    /**
     * solution3: 迭代
     */
    public List<Integer> solution3(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return result;
    }

}
