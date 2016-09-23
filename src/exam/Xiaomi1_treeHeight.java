package exam;

import java.util.Scanner;

/* 求一棵树的高度
 * 输入：总的节点数N，和每一对父子关系
 * 输出：树高
 */
public class Xiaomi1_treeHeight {
	private static class TreeNode {
		public int val;
		public TreeNode chL, chR;
		
		public TreeNode(int val) {
			this.val = val;
			this.chL = null;
			this.chR = null;
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int N = in.nextInt();
        TreeNode[] nodes = new TreeNode[N];
        for (int i = 0; i < N; i++) {
        	nodes[i] = new TreeNode(i);
        }
        
        int idx = 0;
        // build the tree
        for (int i = 0; i < N - 1; i++) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	if (nodes[a].chL == null) {
        		nodes[a].chL = nodes[b];
        	} else {
        		nodes[a].chR = nodes[b];
        	}

        	if (i == 0) {
        		idx = a;
        	}
        }
        
        TreeNode root = nodes[idx];
        int height = depth(root);
        System.out.println(height);
        in.close();
    }

    private static int depth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	return 1 + Math.max(depth(root.chL), depth(root.chR));
    }
}
