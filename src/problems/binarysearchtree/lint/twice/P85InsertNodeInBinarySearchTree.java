package problems.binarysearchtree.lint.twice;

public class P85InsertNodeInBinarySearchTree {

    /**
     * recursive solution
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null)   return root;
        if (root == null)   return node;
        if (node.val <= root.val && root.left == null) {
            root.left = node;
            return root;
        }
        if (node.val > root.val && root.right == null) {
            root.right = node;
            return root;
        }

        if (node.val <= root.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

}

class Solution2 {

    /**
     * iterative solution
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null)   return root;
        if (root == null)   return node;

        TreeNode rootCp = root;
        while (root != null) {
            if (node.val <= root.val && root.left == null) {
                root.left = node;
                break;
            } else if (node.val > root.val && root.right == null) {
                root.right = node;
                break;
            } else if (node.val <= root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return rootCp;
    }

}