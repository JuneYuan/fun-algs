package leetcode1st.linkedlist;

import java.util.Stack;

// 逆置单链表
public class P206 {
	// 迭代
    public ListNode reverseList_iterative(ListNode head) {
        if (head == null)   return null;
        
        ListNode prev = null;
        while (head != null) {
        	ListNode next = head.next;  // 保存head下一节点，用于更新循环变量
            head.next = prev;          // 这句和下句就是头插
            prev = head;
            
            head = next;                // 更新循环变量
        }
        
        return prev;
    }

    // 递归
    public ListNode reverseList_recursive(ListNode head) {
        // 退出条件（两句可以合并）
        if (head == null)   return null;
        if (head.next == null)  return head;
        
        // 递推处理：得到子链表的逆序结果，作为一个整体，在其尾部插入head节点
        ListNode newHead = reverseList_recursive(head.next);
        head.next.next = head;
        
        // “善后”，断开head与原链表后续节点之间的link
        head.next = null;
        
        return newHead;
        
    }

    // 使用栈……
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        
        return dummy.next;
    }

}
