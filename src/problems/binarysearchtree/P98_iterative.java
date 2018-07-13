package leetcode1st.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

// 其实就是迭代方式中序遍历二叉树
public class P98_iterative {
	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> st = new ArrayDeque<>();
		long pre = Long.MIN_VALUE;
		// inorder traverse
		while (root != null || !st.isEmpty()) {
			if (root != null) {
				st.addFirst(root);
				root = root.left;
			} else {
				root = st.pop();
				if (root.val > pre) {
					pre = root.val;
				} else {
					return false;
				}
				
				root = root.right;
			}			
		}
		
		return true;
	}
}
