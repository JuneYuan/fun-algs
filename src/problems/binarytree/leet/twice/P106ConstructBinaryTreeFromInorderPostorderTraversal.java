package problems.binarytree.leet.twice;

public class P106ConstructBinaryTreeFromInorderPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)   return null;
        if (inorder.length == 0 || postorder.length == 0)  return null;
        if (inorder.length != postorder.length)     return null;

        TreeNode root = helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] inorder, int st1, int ed1, int[] postorder, int st2, int ed2) {
        // corner cases
        if (st1 > ed1 || st2 > ed2)     return null;

        // build root TreeNode
        int rootVal = postorder[ed2];
        TreeNode root = new TreeNode(rootVal);
        // find index of rootval in inorder[]
        int index = findIndex(inorder, st1, ed1, rootVal);
        // build left subtree
        root.left = helper(inorder, st1, index - 1, postorder, st2, st2 + index - st1 - 1);
        // build right subtree
        root.right = helper(inorder, index + 1, ed1, postorder, st2 + index - st1, ed2 - 1);

        return root;
    }

    private int findIndex(int[] nums, int st, int ed, int target) {
        for (int i = st; i <= ed; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

}
