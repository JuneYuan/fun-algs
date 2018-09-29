package problems.datastruct.leet.twice;

import java.util.Stack;

public class P232ImplQueueUsingStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public P232ImplQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.empty()) {
            stack1ToStack2(stack1, stack2);
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.empty()) {
            stack1ToStack2(stack1, stack2);
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }

    private void stack1ToStack2(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

}
