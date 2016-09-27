package leetcode.linkedlist;

public class P86 {
	// 创建两个链表，尾插法添加节点
    public ListNode partition(ListNode head, int x) {
        ListNode leftStart = null;
        ListNode rightStart = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftStart == null) {
                    leftStart = head;
                    leftEnd = leftStart;
                } else {
                    leftEnd.next = head;
                    leftEnd = head;
                }
            } else {
                if (rightStart == null) {
                    rightStart = head;
                    rightEnd = rightStart;
                } else {
                    rightEnd.next = head;
                    rightEnd = head;
                }
            }
            
            head = next;
        }
        
        if (leftStart == null)  return rightStart;
        
        leftEnd.next = rightStart;
        return leftStart;
    }

    // 创建两个链表，尾插法添加节点（不能满足这道题保持节点相对顺序的要求）
    public ListNode partition(ListNode head, int x) {
        ListNode leftStart = null;
        ListNode rightStart = null;
        
        while (head != null) {
            ListNode next = head.next;
            // 头插法维护left和right两个链表
            if (head.val < x) {
                head.next = leftStart;
                leftStart = head;
            } else {
                head.next = rightStart;
                rightStart = head;
            }
            
            head = next;    // 更新循环变量
        }
        
        if (leftStart == null)  return rightStart;
        
        ListNode cursor = leftStart;
        while (leftStart.next != null) {
            leftStart = leftStart.next;
        }
        leftStart.next = rightStart;
        
        return cursor;
    }

}
