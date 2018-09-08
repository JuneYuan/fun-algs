package problems.binarytree.leet.twice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P145BinaryTreePostorderTraversal {

    /**
     * solution1: recursion
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.addAll(solution1(root.left));
            result.addAll(solution1(root.right));
            result.add(root.val);
        }

        return result;
    }

    /**
     * solution2: iteration
     */
     public List<Integer> solution2(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         Deque<TreeNode> stack = new ArrayDeque<>();

         if (root != null) {
             stack.push(root);
         }
         TreeNode prev = null;
         while (!stack.isEmpty()) {
             TreeNode curr = stack.peek();

             boolean noChild = (curr.left == null) && (curr.right == null);
             boolean childVisited = false;
             if (prev != null && (curr.left == prev || curr.right == prev)) {
                 childVisited = true;
             }

             if (noChild || childVisited) {
                 curr = stack.pop();
                 result.add(curr.val);
                 prev = curr;
             } else {
                 if (curr.right != null) {
                     stack.push(curr.right);
                 }
                 if (curr.left != null) {
                     stack.push(curr.left);
                 }
             }
         }

         return result;
     }

}
