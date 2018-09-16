package problems.binarytree.leet.twice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P94BinaryTreeInorderTraversal {

    /**
     * solution1: recursion A
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.addAll(solution1(root.left));
            result.add(root.val);
            result.addAll(solution1(root.right));
        }

        return result;
    }

    /**
     * solution2: recursion B
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> ret) {
        if (root != null) {
            helper(root.left, ret);
            ret.add(root.val);
            helper(root.right, ret);
        }
    }

    /**
     * solution3: iteration
     */
     public List<Integer> solution3(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         if (root == null) {
             return result;
         }

         Deque<TreeNode> stack = new ArrayDeque<>();
         while (root != null || !stack.isEmpty()) {
             if (root != null) {
                 stack.push(root);
                 root = root.left;
             } else {
                 root = stack.pop();
                 result.add(root.val);
                 root = root.right;
             }
         }

         return result;
     }

}
