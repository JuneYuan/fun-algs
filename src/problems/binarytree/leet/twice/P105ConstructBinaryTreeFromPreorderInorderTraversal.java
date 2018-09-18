package problems.binarytree.leet.twice;

import java.util.HashMap;
import java.util.Map;

public class P105ConstructBinaryTreeFromPreorderInorderTraversal {

    Map<Integer, Integer> val2Idx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        processMap(inorder);

        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private void processMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            val2Idx.put(inorder[i], i);
        }
    }

    private TreeNode helper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) {
            return null;
        }
        if (s1 == e1 && s2 == e2) {
            return new TreeNode(preorder[s1]);
        }

        int val = preorder[s1];
        TreeNode root = new TreeNode(val);
        int index = val2Idx.get(val);
        root.left = helper(preorder, s1 + 1, s1 + (index - s2), inorder, s2, index - 1);
        root.right = helper(preorder, s1 + (index - s2) + 1, e1, inorder, index + 1, e2);

        return root;
    }

}
