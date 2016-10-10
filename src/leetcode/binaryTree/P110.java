package leetcode.binaryTree;

public class P110 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (Math.abs(height(root.left, 1) - height(root.right, 1)) > 1) {
            return false;
        }
        
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    private int height(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        if (root.left == null && root.right == null) {
            return level + 1;
        }
        if (root.left == null) {
            return height(root.right, level + 1);
        } 
        if (root.right == null) {
            return height(root.left, level + 1);
        } 
        
        int x = height(root.left, level + 1);
        int y = height(root.right, level + 1);
        return Math.max(x, y);
    }

}
