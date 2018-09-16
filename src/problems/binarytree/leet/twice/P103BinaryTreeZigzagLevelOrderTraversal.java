package problems.binarytree.leet.twice;

import java.util.*;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)   return result;

        boolean isOdd = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // level traversal
            int qLen = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            // add level order reverse for even
            if (isOdd) {
                result.add(level);
            } else {
                Collections.reverse(level);
                result.add(level);
            }
            // flip odd and even
            isOdd = !isOdd;
        }

        return result;
    }

}
