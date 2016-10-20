package leetcode.binarySearchTree;

// 递归，并在递归时引入上下界的值
public class P98_clever {
	
	public boolean isValidBST(TreeNode root) {
		if (root == null)  return true;
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean helper(TreeNode root, long lower, long upper) {
		if (root == null)  return true;
		
		if (root.val >= upper || root.val <= lower)  return false;
		boolean isLeftValidBST = helper(root.left, lower, root.val);
		boolean isRightValidBST = helper(root.right, root.val, upper);
		
		return isLeftValidBST && isRightValidBST;
	}
}

