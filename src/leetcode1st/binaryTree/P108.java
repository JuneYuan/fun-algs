package leetcode1st.binaryTree;

// Convert Sorted Array to Binary Search Tree  
public class P108 {	 
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return null;
    	}
    	
        TreeNode root = median(nums, 0, nums.length - 1);
        
        return root;
    }
    
    private TreeNode median(int[] nums, int L, int R) {
    	// L == R的判断也可以没有
        if (L == R) {
            return new TreeNode(nums[L]);
        }
        if (L > R) {
            return null;
        }
        
        int mid = L + (R - L) / 2;
        TreeNode node = new TreeNode(nums[mid]);        
        node.left = median(nums, L, mid - 1);
        node.right = median(nums, mid + 1, R);
        
        return node;
    }
}
