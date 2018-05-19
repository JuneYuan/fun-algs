package leetcode1st.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P124 {
	
	private class Result {
		int singlePath;  // “路径长度”，路径表示：子树中的某节点到当前节点
		int maxPath;     // “路径和”，路径表示：左子树中的某节点经过当前节点到达右子树中的某节点
		
		public Result(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	
	public int maxPathSum(TreeNode root) {
		
		List<Integer> list = new ArrayList<>();
		Arrays.asList(1, 2, 3);
		list.add
		return helper(root).maxPath;
		
	}
	
	private Result helper(TreeNode root) {
		if (root == null) {
			// maxPath should be MIN_VALUE to avoid negative
			return new Result(0, Integer.MIN_VALUE);
		}
		
		Result left = helper(root.left);
		Result right = helper(root.right);
		
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(0, singlePath);  // drop negative
		
		// choose the greater one between 
		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, root.val + left.singlePath + right.singlePath);
		
		return new Result(singlePath, maxPath);
	}
	
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) { val = x; }
}
