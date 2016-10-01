package leetcode.linkedlist;

/*
逆置单链表
迭代法；递归法
 */
public class P206 {
    public ListNode reverseList_iterative(ListNode head) {
        if (head == null)   return null;
        
        ListNode dummy = null;
        while (head != null) {
            ListNode next = head.next;  // 保存head下一节点，用于更新循环变量
            head.next = dummy;          // 这句和下句就是头插
            dummy = head;
            
            head = next;                // 更新循环变量
        }
        
        return dummy;
    }

    public ListNode reverseList_recursive(ListNode head) {
        // 退出条件
        if (head == null)   return null;
        if (head.next == null)  return head;
        
        // 递推处理，完成后head成为最后一个节点
        ListNode newHead = reverseList_recursive(head.next);
        head.next.next = head;
        
        // “善后”，断开head与原链表后续节点之间的link
        head.next = null;
        
        return newHead;
        
    }

}
