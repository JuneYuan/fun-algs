package interview.binaryTree;

import java.util.Stack;

public class InOrder {
	// nr: non-recursive
	
	public static void nrInOrder1(Node root) {
		Stack<Node> s = new Stack<>();
		Node p = root;
		
		while (p != null || !s.isEmpty()) {
			// 对于任一节点，可以看作根节点，根据中序遍历顺序，优先访问其左孩子
			s.push(p);

			// 而左孩子又可看作一根节点，继续访问，直至左孩子为空
			if (p.lChild != null) {
				p = p.lChild;
				continue;
			} else {
			// 每次岀栈时都打印栈顶节点
				if (p.rChild != null) {
					System.out.print(s.peek() + " ");
					p = s.pop().rChild;
					continue;
				} else {
					System.out.print(s.peek() + " ");
					s.pop();
					if (!s.isEmpty()) {
						System.out.print(s.peek() + " ");
						p = s.pop().rChild;
					}
					else
						p = null;
				}
			}
		}
	}
		
	public static void nrInOrder(Node root) {
		Stack<Node> s = new Stack<>();
		Node p = root;
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				p = p.lChild;
			}
			
			if (!s.isEmpty()) {
				p = s.peek();
				System.out.print(p.data);
				s.pop();
				p = p.rChild;
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
		Node G = new Node("G");
		A.lChild = B;  
		A.rChild = C;
		//B.lChild = D;
		B.rChild = E;
		C.lChild = F;
		C.rChild = G;
		
		nrInOrder1(A);
	}

}
