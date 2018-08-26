package problems.binarytree.leet.twice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BInaryTreePreorderTraversal {

    public List<Integer> solution(TreeNode root) {
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
                stack.push(root.left);
            }
        }

        return result;
    }

}
