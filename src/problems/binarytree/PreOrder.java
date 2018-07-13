package problems.binarytree;

import java.util.Stack;

public class PreOrder {
	// nr: non-recursive
	
	public static void nrPreOrder1(Node root) {
		Stack<Node> s = new Stack<>();
		Node p = root;
		
		while (p != null || !s.isEmpty()) {
			// 对于任一节点，可以看作根节点，因此可以直接先访问它
			System.out.println(p + " ");
			s.push(p);
			
			// 若左孩子非空，按相同规则访问左子树，然后访问右子树
			if (p.lChild != null) {
				p = p.lChild;
				continue;
			} else {
				if (p.rChild != null) {
					p = s.pop().rChild;  // 执行这条语句时，栈顶其实就是p，即p == s.pop()
					continue;
				} else {
					s.pop();
					if (!s.isEmpty())
						p = s.pop().rChild;
					else
						p = null;
				}
			}
		}
	}
	
	
	public static void nrPreOrder(Node root) {
		Stack<Node> s = new Stack<>();
		Node p = root;
		while (p != null || !s.empty()) {
			while (p != null) {
				System.out.print(p.data + " ");
				s.push(p);
				p = p.lChild;
			}

			if (!s.empty()) {
				p = s.pop().rChild;
			}
		}
	}
	
	private static class Node {
		String data;
		Node lChild, rChild;

		Node(String data) {
			this.data = data;
		}
	
		public String toString() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		A.lChild = B;  
		A.rChild = C;
		B.rChild = D;
		D.lChild = E;
		D.rChild = F;
		
		nrPreOrder1(A);
	}

}
