package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
二叉树：由层次遍历序列求树高及中序遍历序列
1
1 2 3 4 5 6 7 8 9 10 -1
 */
public class Lianjia2_inOrderBinaryTree {
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
		// 还要考虑节点为0的情况！
		
		TreeNode[] tree = new TreeNode[seq.size()];
		// List<TreeNode> tree = new ArrayList<>(seq.size()); 
		int N = seq.size() - 1;
		
		int currIdx = N / 2;  // 最大非叶节点下标				
		while (currIdx >= 1) {
			int leftIdx = 2 * currIdx, rightIdx = leftIdx + 1;
			TreeNode leftNode = null, rightNode = null;
			if (tree[leftIdx] == null) {
			// if (tree.get(leftIdx) == null) {  // 当前节点孩子为叶节点，如5，4，3
				 leftNode = new TreeNode(seq.get(leftIdx), null, null);
			} else {					  // 当前节点孩子为叶节点，如2
				leftNode = tree[leftIdx];
				// leftNode = tree.get(leftIdx);
			}
			
			if (rightIdx <= N) {
				if (tree[rightIdx] == null) {
				// if (tree.get(rightIdx) == null) {
					rightNode = new TreeNode(seq.get(rightIdx), null, null);
				} else {
					rightNode = tree[rightIdx];
					// rightNode = tree.get(rightIdx);
				}
			}
			tree[currIdx] = new TreeNode(seq.get(currIdx), leftNode, rightNode);
			// tree.set(currIdx, new TreeNode(seq.get(currIdx), leftNode, rightNode));
	
			currIdx--;
		}
		
		return tree[1];
		// return tree.get(1);
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
		
		new Lianjia2_inOrderBinaryTree().solve();		
		
	}
	
}
