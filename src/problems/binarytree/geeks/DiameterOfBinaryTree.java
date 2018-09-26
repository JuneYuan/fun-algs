package problems.binarytree.geeks;

public class DiameterOfBinaryTree {

    public int diameter(TreeNode root) {
        if (root == null)   return 0;

        // left, right height
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);

        // left, right subtree diamerter
        int lDia = diameter(root.left);
        int rDia = diameter(root.right);

        int maxSubDia = Math.max(lDia, rDia);
        return Math.max(maxSubDia, lH + rH + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null)   return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        int maxDistance = sol.diameter(root);
        System.out.println("Max Distance: " + maxDistance);
    }
}
