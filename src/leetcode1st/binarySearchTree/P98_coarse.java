package leetcode1st.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
WAed with case: 
[10,5,15,null,null,6,20]  // 右子树中有节点的值比根小
[3,1,5,0,2,4,6,null,null,null,3]  // 孩子节点的值只能小于或大于祖先，不可以等于
[-2147483648]
 */
public class P98_coarse {
    private List<TreeNode> list = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root) {
        if (root == null)  return true;
        if (root.left == null && root.right == null)  return true;
        
        list.add(new TreeNode(Integer.MIN_VALUE));
        dfs(root, list);
        
        if (list.size() == 0)  return false;
        
        return isSorted(list);

    }
    
    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null || list.size() == 0)  return;
        
        if (root.left != null && root.left.val >= root.val) {
        	list.clear();
        	return;
        }
        if (root.right != null && root.val >= root.right.val) {
        	list.clear();
        	return;
        }
        
        dfs(root.left, list);
        if (list.size() == 0)  return;
        list.add(root);
        dfs(root.right, list);
    }

    private boolean isSorted(List<TreeNode> list) {
    	for (int i = 0; i < list.size() - 1; i++) {
    		if (list.get(i).val >= list.get(i + 1).val) {
    			return false;
    		}
    	}
    	return true;
    }
   
    // [1, 2, 3, null, null, 4, null, null, 5]
    @Test
    public void test1() {
    	int n = 5;
    	TreeNode[] nodes = new TreeNode[n + 1];
    	for (int i = 1; i <= n; i++) {
    		nodes[i] = new TreeNode(i);
    	}
    	
    	nodes[1].left = nodes[2];
    	nodes[1].right = nodes[3];
    	nodes[3].left = nodes[4];
    	nodes[4].right = nodes[5];
    	
    	System.out.println(isValidBST(nodes[1]));
    }

    // [24,-60,null,-60,-6]
    @Test
    public void test2() {
    	TreeNode node1 = new TreeNode(24);
    	TreeNode node2 = new TreeNode(-60);
    	TreeNode node3 = new TreeNode(-60);
    	TreeNode node4 = new TreeNode(-6);
    	node1.left = node2;
    	node2.left = node3;
    	node2.right = node4;

    	System.out.println(isValidBST(node1));
    }
    
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)  { val = x; }
	
	@Override
	public String toString() { return Integer.toString(val); }
}
