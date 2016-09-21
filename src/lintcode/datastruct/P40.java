package lintcode.datastruct;

import java.util.Stack;

// 双栈实现队列
public class P40 {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public P40() {
		// source stack
		stack1 = new Stack<>();
		// target stack
		stack2 = new Stack<>();
	}
	
	public void push(int element) {
		stack1.push(element);
	}
	
	public int pop() {
		if (stack2.empty()) {
			stack1ToStack2(stack1, stack2);
		}
		return stack2.pop();
	}

	public int top() {
		if (stack2.empty()) {
			stack1ToStack2(stack1, stack2);
		}
		return stack2.peek();
	}
	
	private void stack1ToStack2(Stack<Integer> stack1, Stack<Integer> stack2) {
		while (!stack1.empty()) {
			stack2.push(stack1.pop());
		}
	}
}
