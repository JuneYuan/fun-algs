package problems.binarysearchtree.leet.twice;

import java.util.ArrayDeque;
import java.util.Deque;

public class P173BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    private TreeNode curr;

    public P173BSTIterator(TreeNode root) {
        curr = root;
    }

    public boolean hasNext() {
        return (curr != null || !stack.isEmpty());
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();
        TreeNode node = curr;
        curr = curr.right;

        return node.val;
    }

}
