package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
二叉树：由层次遍历序列求树高及中序遍历序列
1
1 2 3 4 5 6 7 8 9 10 -1
 */
public class Lianjia4_inOrderBinaryTree {
	Scanner in = new Scanner(System.in);
	
	private class TreeNode {
		int data;
		TreeNode left, right;
		
		TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	
		@Override
		public String toString() {
			return Integer.toString(data);
		}
	}
	
	public void solve() {
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			List<Integer> seq = new ArrayList<>();
			seq.add(-1);  // 占位符，是真正节点下表从1开始
			int x = in.nextInt();
			while (x != -1) {
				seq.add(x);
				x = in.nextInt();
			}
			
			int N = seq.size();
			int height = (int) Math.ceil(Math.log(N) / Math.log(2));
			System.out.print(height + " ");
			
			TreeNode root = buildTree(seq);
			inOrder(root);
		}
		
		in.close();
	}
	
	TreeNode buildTree(List<Integer> seq) {
		
	}

	void inOrder(TreeNode root) {
		if (root == null)  return;
		
		inOrder(root.left);
		if (root.data != 0) {
			System.out.print(root.data + " ");
		}
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		
		new Lianjia4_inOrderBinaryTree().solve();		
		
	}
	
}
